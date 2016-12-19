import com.sohu.mrd.videoDocId.simhash.SimHasher;
import com.sohu.mrd.videoDocId.utils.KillPuctuation;
import com.sohu.mrd.videoDocId.utils.KillTag;
import com.sohu.mrd.videoDocId.utils.SimHashKit;
/**
 * @author  Jin Guopan
 * @version 2016-12-19
 */
public class TestSimhash {
	public static void main(String[] args) {
		String hash9="1010111110001010000100010100110010000110001001111111001111000111";
		String  hash10="1010111110101010000100000100110010000110101111111110101111100101";
		String title="超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝10";
		String content="超尴尬！素颜出镜的陈坤，竟被指撞脸宋小宝10";
		String clearTitle = KillPuctuation.killPuctuation(KillTag.killTags(title)) ;
		String clearContent = KillPuctuation.killPuctuation(KillTag.killTags(content)) ;
		SimHasher simHasher = new SimHasher(clearTitle+"\t"+clearContent);
		//String hash10=simHasher.getHash();
		System.out.println("hash10 "+hash10);
		int count=SimHashKit.getHanMingDistance(hash9, hash10);
		System.out.println("count "+count);
	}
}
