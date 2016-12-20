import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sohu.mrd.framework.redis.client.client.CodisLocalClient;
import redis.clients.jedis.JedisPoolConfig;
/**
 * Created by yahuilu001664 on 2016/10/25.
 */
public class RedisClientTest {
    private static final Logger logger = LoggerFactory.getLogger(RedisClientTest.class);
    private static CodisLocalClient codisLocalClient = null;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinEvictableIdleTimeMillis(60000);
        config.setTimeBetweenEvictionRunsMillis(30000);
        codisLocalClient = CodisLocalClient
                .create()
                .build();         // 以默认方式创建测试环境下的codis客户端
    }
 
    public static void insertKey(String key, String value) { // 向codis集群中存放数据
        logger.info("insert a key into codis,the key is " + key + " and it's value is " + value);
        key = codisLocalClient.mkKey(key, "prefix");
        codisLocalClient.set(key, value);
    }
 
    public static String getValueByKey(String key) { //获取指定key的value值
        key = codisLocalClient.mkKey(key, "prefix");
        return codisLocalClient.get(key);
    }
 
    public static Long deleteKey(String key) { // 删除codis集群中存放的指定key
        logger.info("delete the key" + key);
        key = codisLocalClient.mkKey(key, "prefix");
        return codisLocalClient.del(key);
    }
    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            String key = "test___jinguopan";
            String value = "test_value_jinguopan";
            key = key + i;
            value = value + i;
            insertKey(key, value);
            System.out.println(getValueByKey(key));
           // deleteKey(key);
        }
    }
}