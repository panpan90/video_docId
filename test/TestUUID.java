import java.util.UUID;

/**
 * @author  Jin Guopan
 * @version 2016-12-19
 */
public class TestUUID {
	public static void main(String[] args) {
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println("uuid "+uuid);
	}
}
