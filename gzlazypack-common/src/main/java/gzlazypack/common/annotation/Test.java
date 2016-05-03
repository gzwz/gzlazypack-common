package gzlazypack.common.annotation;

@ObjectDescribe(cn = "测试对象", type = ObjectType.MODEL)
public class Test {

	@ColumnDescribe(cn = "主键")
	private String id;

	@ColumnDescribe(cn = "名称", desc = "测试用的名称")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
