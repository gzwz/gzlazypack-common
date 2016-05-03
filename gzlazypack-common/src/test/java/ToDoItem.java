import java.util.List;

public class ToDoItem {

	private String id;

	private String name;

	private ToDoItemDetail detail;

	private List<ToDoItemDetail> list;

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

	public ToDoItemDetail getDetail() {
		return detail;
	}

	public void setDetail(ToDoItemDetail detail) {
		this.detail = detail;
	}

	public List<ToDoItemDetail> getList() {
		return list;
	}

	public void setList(List<ToDoItemDetail> list) {
		this.list = list;
	}

}
