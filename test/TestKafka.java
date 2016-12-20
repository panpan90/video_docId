import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sohu.mrd.videoDocId.utils.FileKit;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
/**
 @author Jin Guopan
 @creation 2016年12月20日
 */
public class TestKafka {
	private  static final String REALTIME_NEWS_TOPIC="mrd.allnews.all_realtime_news";
	private static final String VIDEO_TOPIC = "mrd.news.crawl.video";
	private static final String VIDEO_CONSUMER_GROUP="mrd.news.crawl.video.videoDocId.consumer.group456";
	public static void main(String[] args) {
		Properties  props =  new Properties();
		props.put("group.id", VIDEO_CONSUMER_GROUP);
		props.put("zookeeper.connect", "10.10.91.91:2181,10.10.91.92:2181,10.10.91.93:2181");
		props.put("auto.offset.reset", "largest");
		props.put("auto.commit.interval.ms", "1000");
		props.put("partition.assignment.strategy", "roundrobin");
		ConsumerConfig config = new ConsumerConfig(props);
		ConsumerConnector  consumerConnector=Consumer.createJavaConsumerConnector(config);
		Map<String,Integer>  topicCountMap = new HashMap<String,Integer>();
		topicCountMap.put(VIDEO_TOPIC, 1);//创建一个消费者
		//string 是 topic List<KafkaStream<byte[], byte[]>> 是对应的流
		Map<String, List<KafkaStream<byte[], byte[]>>>  topicStreamMap=consumerConnector.createMessageStreams(topicCountMap);
		List<KafkaStream<byte[], byte[]>> streams=topicStreamMap.get(VIDEO_TOPIC);
		int count=0;
		for(int i=0;i<streams.size();i++)
		{
			KafkaStream<byte[], byte[]> stream=streams.get(i);
			ConsumerIterator<byte[], byte[]> it=stream.iterator();
			while(it.hasNext())
			{
				MessageAndMetadata<byte[], byte[]>  data=it.next();
				String topic=data.topic();
				String message = new String(data.message());
				StringBuilder sb = new StringBuilder();
				sb.append(message);
				sb.append("\n");
				FileKit.write2File(sb.toString(), "data/video_data", true);
				sb.delete(0, sb.length());
				System.out.println("message "+message);
				System.out.println("共读取了 "+(++count)+"条数据");
			}
		}
	}
}
