package gzlazypack.common.util;

import java.util.HashMap;
import java.util.Map;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.connection.RandomLoadBalancer;

public class RedissonUtil {
	
	private static Map<String, Redisson> redissonMap = new HashMap<String, Redisson>();
	
	/**
	 * 获取单节点redis的Redisson操作实例
	 * @param address 例"127.0.0.1:6379"
	 * @return
	 */
	public static Redisson getSingleRedisson(String address) {
		if (!redissonMap.containsKey(address)) {
			Config config = new Config();
			config.useSingleServer().setAddress(address);

			redissonMap.put(address, Redisson.create(config));
		} 
		return redissonMap.get(address);
	}
	
	/**
	 * 获取一主多从节点redis的Redisson操作实例
	 * @param masterAddress 例"127.0.0.1:6379"
	 * @param slaveAaddress 例"127.0.0.1:7000", "127.0.0.1:7001"
	 * @return
	 */
	public static Redisson getMasterSlaveRedisson(String masterAddress, String ... slaveAaddress) {
		if (!redissonMap.containsKey(masterAddress)) {
			Config config = new Config();
			config.useMasterSlaveConnection()
			    .setMasterAddress(masterAddress)
			    .setLoadBalancer(new RandomLoadBalancer())
			    .addSlaveAddress(slaveAaddress);

			redissonMap.put(masterAddress, Redisson.create(config));
		} 
		return redissonMap.get(masterAddress);
	}
	
	/**
	 * 获取哨兵模式多节点redis的Redisson操作实例
	 * @param masterName
	 * @param sentinelAaddress 例"127.0.0.1:7000", "127.0.0.1:7001"
	 * @return
	 */
	public static Redisson getSentinelRedisson(String masterName, String ... sentinelAaddress) {
		if (!redissonMap.containsKey(masterName)) {
			Config config = new Config();
			config.useSentinelConnection()
			    .setMasterName("masterName")
			    .addSentinelAddress(sentinelAaddress);

			redissonMap.put(masterName, Redisson.create(config));
		} 
		return redissonMap.get(masterName);
	}
	
	/**
	 * 获取集群模式多节点redis的Redisson操作实例
	 * @param clusterName
	 * @param scanInterval 集群状态扫描间隔时间，毫秒
	 * @param nodeAaddress 例"127.0.0.1:7000", "127.0.0.1:7001"
	 * @return
	 */
	public static Redisson getClusterRedisson(String clusterName, Integer scanInterval, String ... nodeAaddress) {
		if (!redissonMap.containsKey(clusterName)) {
			Config config = new Config();
			config.useClusterServers()
			    .setScanInterval(scanInterval) // sets cluster state scan interval
			    .addNodeAddress(nodeAaddress);

			redissonMap.put(clusterName, Redisson.create(config));
		} 
		return redissonMap.get(clusterName);
	}
	
	public void clearRedissonInstance(String key) {
		redissonMap.remove(key);
	}
	
	public static void shutdownRedissonInstance(String key) {
		redissonMap.get(key).shutdown();
		redissonMap.remove(key);
	}
}
