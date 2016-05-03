/*import java.util.List;

import lazypack.common.util.PropertiesUtil;

import org.apache.commons.lang.StringUtils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.ons.model.v20151020.OnsRegionListRequest;
import com.aliyuncs.ons.model.v20151020.OnsRegionListResponse;
import com.aliyuncs.ons.model.v20151020.OnsTopicCreateRequest;
import com.aliyuncs.ons.model.v20151020.OnsTopicCreateResponse;
import com.aliyuncs.ons.model.v20151020.OnsTopicGetRequest;
import com.aliyuncs.ons.model.v20151020.OnsTopicGetResponse;
import com.aliyuncs.ons.model.v20151020.OnsRegionListResponse.RegionDo;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;


public class TestONSApi {
	
	String regionId = PropertiesUtil.getProperiesValue("aliyun_region_id",
			"system.properties");
	String accessKey = PropertiesUtil.getProperiesValue("aliyun_access_key",
			"system.properties");
	String secretKey = PropertiesUtil.getProperiesValue("aliyun_secret_key",
			"system.properties");

	IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey,
			secretKey);
	IAcsClient client = new DefaultAcsClient(profile);
	
	public List<RegionDo> queryOnsRegionList() {
		OnsRegionListRequest request = new OnsRegionListRequest();
		request.setAcceptFormat(FormatType.JSON);
		request.setPreventCache(System.currentTimeMillis());

		try {
			OnsRegionListResponse response = client.getAcsResponse(request);
			List<RegionDo> list = response.getData();
			return list;
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	*//**
	 * 查询topic状态
	 * 
	 * @param topicName
	 *            主题名称
	 *//*
	public void queryTopicStatus(String topicName) {
		queryTopicStatus(topicName, null, null);
	}

	*//**
	 * 查询topic状态
	 * 
	 * @param topicName
	 *            主题名称
	 * @param regionId
	 *            阿里云网关所在区，默认cn-hangzhou
	 * @param onsRegionId
	 *            ONS topic所在区
	 * @return
	 *//*
	public List<OnsTopicGetResponse.PublishInfoDo> queryTopicStatus(String topicName,
			String regionId, String onsRegionId) {

		if (StringUtils.isBlank(regionId)) {
			regionId = PropertiesUtil.getProperiesValue("aliyun_region_id",
					"system.properties");
		}

		if (StringUtils.isBlank(onsRegionId)) {
			onsRegionId = PropertiesUtil.getProperiesValue(
					"aliyun_ons_region_id", "system.properties");
		}
		String accessKey = PropertiesUtil.getProperiesValue(
				"aliyun_access_key", "system.properties");
		String secretKey = PropertiesUtil.getProperiesValue(
				"aliyun_secret_key", "system.properties");

		IClientProfile profile = DefaultProfile.getProfile(regionId, accessKey,
				secretKey);
		IAcsClient client = new DefaultAcsClient(profile);

		OnsTopicGetRequest request = new OnsTopicGetRequest();
		request.setAcceptFormat(FormatType.JSON);
		request.setTopic(topicName);
		request.setOnsRegionId(onsRegionId);
		request.setPreventCache(System.currentTimeMillis());
		try {
			OnsTopicGetResponse response = client.getAcsResponse(request);
			List<OnsTopicGetResponse.PublishInfoDo> publishInfoDoList = response
					.getData();
			return publishInfoDoList;
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createTopic(String topicName) {

		OnsTopicCreateRequest request = new OnsTopicCreateRequest();
		request.setAcceptFormat(FormatType.JSON);
		request.setTopic(topicName);
		request.setOnsRegionId("daily");
		request.setPreventCache(System.currentTimeMillis());
		try {
			OnsTopicCreateResponse response = client.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/