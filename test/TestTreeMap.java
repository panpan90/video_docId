import java.util.TreeMap;
import org.junit.Test;
/**
 * @author  Jin Guopan
 * @version 2016-12-15
 */
public class TestTreeMap{
	/**
	 * treemap 的 
	 */
	@Test
	public void testTreeMap()
	{
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("0.85&0.84&"+(10-3)+"&3", "1");
		map.put("0.94&0.95&"+(10-2)+"&2", "1");
		map.put("0.85&0.84&"+(10-1)+"&1", "1");
		System.out.println(map.toString());
		
	}
	 
}
