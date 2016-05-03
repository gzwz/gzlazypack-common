import gzlazypack.common.util.LogFlow;
import gzlazypack.common.util.RedissonUtil;
import gzlazypack.common.util.UUIDGenerator;

import java.util.ArrayList;
import java.util.Date;

import org.redisson.Redisson;
import org.redisson.core.RMap;

public class RedissonTest {

	public static void main(String[] args) {

		LogFlow logFlow = new LogFlow("test");

		Redisson redisson = RedissonUtil.getSingleRedisson("127.0.0.1:6379");

		logFlow.record("第一次redisson实例获取完毕");
		RMap<String, ToDoItem> map = redisson.getMap("test");

		logFlow.record("第一次map获取完毕");

		ToDoItem item = new ToDoItem();
		item.setId(UUIDGenerator.getUUID());
		item.setName("test");
		item.setDetail(new ToDoItemDetail());
		item.getDetail().setCreateDate(new Date());
		item.getDetail().setRemark("aaaaaaaa");
		item.setList(new ArrayList<ToDoItemDetail>());

		for (int j = 0; j < 3; j++) {
			ToDoItemDetail detail = new ToDoItemDetail();
			detail.setCreateDate(new Date());
			detail.setRemark("bbbbbb");
			item.getList().add(detail);
		}

		logFlow.record("第一次对象构建完毕");

		map.put("1", item);

		logFlow.record("第一次map存值完毕");

		map.get("1");

		logFlow.record("第一次map取值完毕");
		// ////////第二次操作

		Redisson redisson2 = RedissonUtil.getSingleRedisson("127.0.0.1:6379");

		logFlow.record("第二次redisson实例获取完毕");
		RMap<String, ToDoItem> map2 = redisson2.getMap("test");

		logFlow.record("第二次map获取完毕");

		ToDoItem item2 = new ToDoItem();
		item2.setId(UUIDGenerator.getUUID());
		item2.setName("test");
		item2.setDetail(new ToDoItemDetail());
		item2.getDetail().setCreateDate(new Date());
		item2.getDetail().setRemark("aaaaaaaa");
		item2.setList(new ArrayList<ToDoItemDetail>());

		for (int j = 0; j < 3; j++) {
			ToDoItemDetail detail = new ToDoItemDetail();
			detail.setCreateDate(new Date());
			detail.setRemark("bbbbbb");
			item2.getList().add(detail);
		}

		logFlow.record("第二次对象构建完毕");

		map2.put("2", item2);

		logFlow.record("第二次map存值完毕");

		map2.get("2");

		logFlow.record("第二次map取值完毕");

		// ////////第三次操作

		Redisson redisson3 = RedissonUtil.getSingleRedisson("127.0.0.1:6379");

		logFlow.record("第二次redisson实例获取完毕");
		RMap<String, ToDoItem> map3 = redisson3.getMap("test");


		logFlow.record("第三次map获取完毕");

		ToDoItem item3 = new ToDoItem();
		item3.setId(UUIDGenerator.getUUID());
		item3.setName("test");
		item3.setDetail(new ToDoItemDetail());
		item3.getDetail().setCreateDate(new Date());
		item3.getDetail().setRemark("aaaaaaaa");
		item3.setList(new ArrayList<ToDoItemDetail>());

		for (int j = 0; j < 3; j++) {
			ToDoItemDetail detail = new ToDoItemDetail();
			detail.setCreateDate(new Date());
			detail.setRemark("bbbbbb");
			item3.getList().add(detail);
		}

		logFlow.record("第三次对象构建完毕");

		map3.put("3", item3);

		logFlow.record("第三次map存值完毕");

		map3.get("3");

		logFlow.record("第三次map取值完毕");

		RedissonUtil.shutdownRedissonInstance("127.0.0.1:6379");
		logFlow.record("关闭");
		
		logFlow.print();
	}
}
