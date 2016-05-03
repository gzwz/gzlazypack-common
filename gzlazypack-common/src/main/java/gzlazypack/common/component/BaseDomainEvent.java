package gzlazypack.common.component;

@SuppressWarnings("serial")
public class BaseDomainEvent extends BaseEvent {

	/**
	 * model名加方法名，如ProjectUser.create
	 */
	private String name;

	/**
	 * 参数json串 CreateProjectUserCommand command 当有多个参数时，记录为json1,json2...
	 */
	private String params;

	public BaseDomainEvent() {
		super();
	}

	public BaseDomainEvent(String name, String params, String describe, String topicName, String tags) {
		super(topicName, tags, describe);
		setName(name);
		setParams(params);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
