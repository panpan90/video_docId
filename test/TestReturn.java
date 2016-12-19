/**
 * @author  Jin Guopan
 * @version 2016-12-12
 */
public class TestReturn {
	public static void main(String[] args) {
		test(null);
	}
	public static void  test(String content)
	{
		if(content==null)
			return;
		if(content.equals(""))
			return;
		System.out.println("接收到的content 为  "+content);
	}
}
