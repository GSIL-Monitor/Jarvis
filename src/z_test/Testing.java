package z_test;

/**
 * Created by Poker on 2017/2/20.
 */
public class Testing {

	private Child mTest;

	public static void main(String[] args) {
//		String s = "%s";
//		System.out.println(String.format(s, 1));
		System.out.println(null instanceof Testing);
	}

	private class Child {
		public String tag;
		public void init() {
			tag = Child.class.getName();
		}
	}

	private void doTest() {
		System.out.println(mTest.tag.length());
	}


}
