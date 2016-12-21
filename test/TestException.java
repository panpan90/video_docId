import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
/**
 * @author Jin Guopan
 @creation 2016年12月21日
 */
public class TestException {
	private static final Logger LOG = Logger.getLogger(TestException.class);
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("");
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage());
			LOG.error(e);
		}
		
	}
}
