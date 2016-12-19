import com.sohu.mrd.videoDocId.utils.HostDomainExtractKit;
/**
 * @author  Jin Guopan
 * @version 2016-12-8
 */
public class TestDomain {
	public static void main(String[] args) {
		  String url="http://cms.k.sohu.com/server/interface/readinfo.go?aid=1001&date=2013-07-25&ids=19293557_1&token=9e2e0350c8f8aa0db78ef6cbe70dc6fa";
		  String url1="http://news.youth.cn/yl/201611/t20161116_8851373.htm";
		  String url2="http://news.sina.com.cn/china/xlxw/2016-11-30/doc-ifxyawxa3196598.shtml";
		  String url3="http://www.baidu.com";
		 String  host = HostDomainExtractKit.extractURLHost(url);
		 String  topDomain=HostDomainExtractKit.getTopLevelDomain(url);
		 System.out.println("host "+host);
		 System.out.println("topDomain "+topDomain);
	}
}
