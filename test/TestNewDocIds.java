import com.sohu.mrd.videoDocId.service.GenerateDocIdService;
/**
 * @author Jin Guopan
 * @version 2016-12-19 {"sort":"","url":"
 *          http://my.tv.sohu.com/us/264452204/85939812.shtml
 *          ","title":"超尴尬！素颜出镜的陈坤
 *          ，竟被指撞脸宋小宝","bread":[],"content":"超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝
 *          ","content_length
 *          ":20,"title_length":20,"media":"嘻嘻娱乐视频号","image_count
 *          ":0,"summary":"","
 *          image_string":"","publish_time":"1479279373475","from":" k.sohu.com
 *          ","source":"嘻嘻娱乐视频号","page_title":"","is_force_rec":0,"cmsid":"-1","
 *          token
 *          ":"c582a96b-3e42-4c80-a3e5-275cdf9e220a", "st":18,"old_title":""}
 */
public class TestNewDocIds {
	/**
	 * 未进行排重的  10 14 19 
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateDocIdService generateDocIdService = GenerateDocIdService
				.getInstance();
		String url = "http://my.tv.sohu.com/us/264452204/85939812.shtml00078665";
		String title = "超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝";
		String content = "超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝。。";
//		for(int i=0;i<=9;i++)
//		{
			long startTime = System.currentTimeMillis();
			String docId = generateDocIdService.getDocId(url , title ,
					content);
			System.out.println(docId);
			long endTime = System.currentTimeMillis();
			System.out.println("costTime " + (endTime - startTime));
//		}
		
		// String docId=generateDocIdService.getDocId(url+11, title+11,
		// content+11);
	}
}
