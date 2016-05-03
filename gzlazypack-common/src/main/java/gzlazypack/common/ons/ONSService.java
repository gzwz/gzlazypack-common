package gzlazypack.common.ons;

import gzlazypack.common.component.BaseEvent;
import gzlazypack.common.util.PropertiesUtil;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

@Service
public class ONSService implements InitializingBean {

	String regionId = PropertiesUtil.getProperiesValue("aliyun_region_id",
			"system.properties");
	String accessKey = PropertiesUtil.getProperiesValue("aliyun_access_key",
			"system.properties");
	String secretKey = PropertiesUtil.getProperiesValue("aliyun_secret_key",
			"system.properties");

	IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey,
			secretKey);
	IAcsClient client = new DefaultAcsClient(profile);
	
	private Producer producer;
	
	/**
	 * 每个应用在启动时调该方法创建各自的producer。 producerId必须提前在阿里云建好，每个应用建一个即可
	 */
	public void startProducer(String producerId) {
		if (StringUtils.isNotBlank(producerId)) {
			Properties properties = new Properties();
			properties.put(PropertyKeyConst.ProducerId, producerId);
			properties.put(PropertyKeyConst.AccessKey, accessKey);
			properties.put(PropertyKeyConst.SecretKey, secretKey);
			Producer producer = ONSFactory.createProducer(properties);
			// 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
			producer.start();
			this.producer = producer;
		}
	}

	/**
	 * 每个应用在启动时调该方法创建各自的订阅。 consumerId必须提前在阿里云建好，每个监听处理操作独立建一个
	 * 
	 * @param consumerId	消费者id，在阿里云已建好，每个监听器建一个，相当于监听器名称
	 * @param topicName		主题名称
	 * @param subExpression
	 *            消息tag过滤，默认为*
	 */
	public void subscribe(String consumerId, String topicName,
			String subExpression, MessageListener listener) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ConsumerId, consumerId);
		properties.put(PropertyKeyConst.AccessKey, accessKey);
		properties.put(PropertyKeyConst.SecretKey, secretKey);

		if (StringUtils.isBlank(subExpression)) {
			subExpression = "*";
		}

		Consumer consumer = ONSFactory.createConsumer(properties);
		consumer.subscribe(topicName, subExpression, listener);
		consumer.start();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String producerId = PropertiesUtil.getProperiesValue("aliyun_ons_producer_id",
				"system.properties");
		startProducer(producerId);
	}
	
	/**
	 * 发送消息
	 * @param topicName	发送的主题
	 * @param tags	服务端分类过滤用的标签
	 * @param body	消息主体
	 * @param key	业务id
	 * @return
	 */
	public String sendMessage(String topicName, String tags, byte[] body, String key) {
		Message message = new Message(topicName, tags, body);
		message.setKey(key);
		return producer.send(message).getMessageId();
	}
	
	public String publishEvent(BaseEvent event) {
		try {
			return sendMessage(event.getTopicName(), event.getTags(), JSON.toJSONString(event).getBytes("UTF-8"), event.getKey());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
