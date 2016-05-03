package gzlazypack.common.component;

import gzlazypack.common.util.SysProperties;
import gzlazypack.common.util.UUIDGenerator;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class BaseEvent implements Serializable {

	private String id;

	/**
	 * 事件所属流程id
	 */
	private String sagaId;

	/**
	 * 事件文字描述
	 */
	private String describe;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 来源项目
	 */
	private String projectId;

	/**
	 * 来源环境
	 */
	private String envId;

	/**
	 * 事件所属主题
	 */
	private String topicName;

	/**
	 * 事件分类过滤标签
	 */
	private String tags;

	/**
	 * 业务标识
	 */
	private String key;

	public BaseEvent() {
		super();
	}
	
	public BaseEvent(String describe) {
		super();
		this.topicName = "NO_TOPIC";
		this.tags = "*";
		this.describe = describe;
		this.projectId = SysProperties.getInstance().get("projectId");
		this.envId = SysProperties.getInstance().get("envId");
		this.createDate = new Date();
		this.id = UUIDGenerator.getUUID();
	}
	
	public BaseEvent(String topicName, String tags, String describe) {
		super();
		this.topicName = topicName;
		this.tags = tags;
		this.describe = describe;
		this.projectId = SysProperties.getInstance().get("projectId");
		this.envId = SysProperties.getInstance().get("envId");
		this.createDate = new Date();
		this.id = UUIDGenerator.getUUID();
	}

	public BaseEvent(String topicName, String tags, String describe, String projectId, String envId) {
		super();
		this.topicName = topicName;
		this.tags = tags;
		this.describe = describe;
		this.projectId = projectId;
		this.envId = envId;
		this.createDate = new Date();
		this.id = UUIDGenerator.getUUID();
	}
	
	public String getSagaId() {
		return sagaId;
	}

	public void setSagaId(String sagaId) {
		this.sagaId = sagaId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEnvId() {
		return envId;
	}

	public void setEnvId(String envId) {
		this.envId = envId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
