import com.sohu.mrd.videoDocId.simhash.SimHasher;
/**
 * @author  Jin Guopan
 * @version 2016-11-23
 */
public class TestSimHasher {
	public static void main(String[] args) {
		SimHasher simHasher=new SimHasher("我正在吃饭");
		System.out.println(simHasher.getSignature());
	}
}
