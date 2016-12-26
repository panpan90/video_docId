package com.sohu.mrd.test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sohu.mrd.videoDocId.redis.RedisCrud;
import com.sohu.mrd.videoDocId.service.GenerateDocIdService;
import com.sohu.mrd.videoDocId.service.GenerateDocIdServiceByRedis;
import com.sohu.mrd.videoDocId.utils.FileKit;
/**
 * @author Jin Guopan
  @creation 2016年12月22日
 */
public class TestRedisGenerateDocId {
	private static final Logger LOG = Logger.getLogger(TestRedisGenerateDocId.class);
	public static void main(String[] args) {
		 GenerateDocIdServiceByRedis generateDocIdServiceByRedis = GenerateDocIdServiceByRedis.getInstance();
		 String url = "http://www.baidu.com";
		 String title="我是视频的标题";
		 String content="我是视频的标题";
		 long start_time = System.currentTimeMillis();
		 String docId=generateDocIdServiceByRedis.getDocId(url, title, content);
		 long end_time = System.currentTimeMillis();
		 System.out.println(end_time-start_time);
		 System.out.println("docId为 "+docId);
	}
	
	@Test
	public void testRedis()
	{
		long all_start_Time = System.currentTimeMillis();
		try {
			FileInputStream fis = new FileInputStream("data/kafkaData");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String temp="";
			while((temp=br.readLine())!=null)
			{
				if(!temp.trim().equals(""))
				{
					String[] temps=temp.split("\t", -1);
					String url=temps[0];
					String title=temps[1];
					String content=temps[2];
					long startTime = System.currentTimeMillis();
					GenerateDocIdServiceByRedis generateDocIdServiceByRedis = GenerateDocIdServiceByRedis.getInstance();
					String docId=generateDocIdServiceByRedis.getDocId(url, title, content);
					long endTime = System.currentTimeMillis();
					StringBuilder sb = new StringBuilder();
					sb.append(docId);
					sb.append("\t");
					sb.append(url);
					sb.append("\t");
					sb.append(title);
					sb.append("\t");
					sb.append(content);
					sb.append("\t");
					sb.append(endTime-startTime);
					sb.append("\n");
					String writeStr=sb.toString();
					FileKit.write2File(writeStr, "data/newredisResult_2016_12_26_1", true);
					System.out.println(writeStr);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		long all_end_time=System.currentTimeMillis();
		LOG.info("总耗时  "+(all_end_time-all_start_Time)/1000+"s");
	}
	//7ad8e0d73558d9fd-86a546d02e91a55c
	@Test
	public void  testRedisAccuracy()
	{
		GenerateDocIdServiceByRedis generateDocIdService=GenerateDocIdServiceByRedis.getInstance();
		String url = "http://my.tv.sohu.com/us/291111068/86613461.shtml11999";
		String title= "粉红猪小妹玩具故事 佩奇过生日拆礼物";
		String content = "粉红猪小妹玩具故事 佩奇过生日拆礼物";
		long  start_time= System.currentTimeMillis(); 
		String docId=generateDocIdService.getDocId(url, title, content);
		String docId2=generateDocIdService.getDocId(url, title, content);
		long  end_time= System.currentTimeMillis();
		System.out.println(end_time-start_time);
		System.out.println("docId "+docId);
		System.out.println("docId2 "+docId2);
	}
	
	@Test
	public void  testRedis2()
	{
		
	}
}
