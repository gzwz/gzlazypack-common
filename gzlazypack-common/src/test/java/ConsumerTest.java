import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

public class ConsumerTest {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ConsumerId, "CID_HY_TRADE");
		properties.put(PropertyKeyConst.AccessKey, "0nAfYRauR8NVckb9");
		properties.put(PropertyKeyConst.SecretKey,
				"jJYJlFdzEGvTM02okhtRIMADHwDsJy");
		Consumer consumer = ONSFactory.createConsumer(properties);
		consumer.subscribe("lehu-order-status-changed", "*",
				new MessageListener() {

					@Override
					public Action consume(Message message,
							ConsumeContext context) {
						System.out.println("收到消息:"+ message.getMsgID() + new String(message.getBody()));
						return Action.CommitMessage;
					}
				});
		consumer.start();
		System.out.println("Consumer Started");
	}
}
