import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import com.sohu.mrd.videoDocId.service.GenerateDocIdService;
import com.sohu.mrd.videoDocId.utils.FileKit;
/**
 * @author Jin Guopan
 @creation 2016年12月21日
 */
public class TestOnlineByHbase {
	private static final Logger LOG = Logger.getLogger(TestOnlineByHbase.class);
	public static void main(String[] args) {
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
					GenerateDocIdService generateDocIdService=GenerateDocIdService.getInstance();
					String docId=generateDocIdService.getDocId(url, title, content);
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
					FileKit.write2File(writeStr, "data/newOnlineResult2", true);
					System.out.println(writeStr);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		long all_end_time=System.currentTimeMillis();
		LOG.info("总耗时  "+(all_end_time-all_start_Time)/1000+"s");
	}
}
