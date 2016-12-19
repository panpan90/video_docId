import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sohu.mrd.videoDocId.model.URLInfo;
import com.sohu.mrd.videoDocId.service.GenerateDocIdService;
import com.sohu.mrd.videoDocId.utils.HttpClientUtil;
/**
 * @author  Jin Guopan
 * @version 2016-11-22
 */
public class TestGenerateDocId{
	public static final Logger LOG=Logger.getLogger(TestGenerateDocId.class);
	public static void main(String[] args){
		long startTime=System.currentTimeMillis();
		//GenerateDocIdService generateDocid=new GenerateDocIdService();
		//String docId=generateDocid.generateDocId("http://news.youth.cn/yl/201611/t20161116_8851373.htm","123");
		//System.out.println("docId "+docId);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	@Test
	public void generateDocid()
	{
		for(int i=0;i<10;i++)
		{
			
			long startTime=System.currentTimeMillis();
			String url="http://localhost:8080/video_docid/video_docId?title=超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝&url=http://news.youth.cn/yl/201611/t20161116_8851373.htm"+(i%10);
			String result=HttpClientUtil.executeGet(url);
//			HashMap<String,String>  hashMap=new HashMap<String,String>();
//			hashMap.put("title", "我是标题党");
//			hashMap.put("url", "http://www.baidu.com");
//			String postResult=HttpClientUtil.doPost(url, hashMap, "utf-8");
			long  endTime=System.currentTimeMillis();
			System.out.println("产生docId需要的时间花费的时间  "+(endTime-startTime));
			System.out.println(result);
		}
	}
	@Test
	public void  generateDocId1()
	{
		for(int i=200;i<300;i++)
		{
			//String url="http://localhost:8080/video_docid/getDocId?title=超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝"+(i)+"&url=http://news.youth.cn/yl/201611/t20161116_8851373.htm880789"+(i);
			String disurl="http://10.10.120.165:8080/video_docid/getDocId?title=超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝"+(i)+"&url=http://news.youth.cn/yl/201611/t20161116_8851373.htm880789"+(i);
			long  startTime=System.currentTimeMillis();
			String postResult=HttpClientUtil.executeGet(disurl);
			long  endTime=System.currentTimeMillis();
			System.out.println("产生docId需要的时间花费的时间  "+(endTime-startTime));
			System.out.println(postResult);
		}
		
	}
	@Test
	public void  testhost_domain()
	{
		//GenerateDocIdService generateDocId = new GenerateDocIdService();
////		URLInfo urlInfo=generateDocId.extractURLHost("http://news.sina.com.cn/china/xlxw/2016-11-30/doc-ifxyawxa3196598.shtml");
////		String host=urlInfo.getHost();
//		    LOG.info(host);
		
	}
}
