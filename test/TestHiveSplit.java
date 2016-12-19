/**
 * @author  Jin Guopan
 * @version 2016-12-14
 */
public class TestHiveSplit {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
	    sb.append("123");
	    sb.append("\001");
	    sb.append("456");
	    String s=sb.toString();
	    String[] ss=s.split("\001", -1);
	    for(int i=0;i<ss.length;i++)
	    {
	    	System.out.println("ss[i]"+ss[i]);
	    }
	}
}
