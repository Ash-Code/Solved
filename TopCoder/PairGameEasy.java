package TopCoder;
public class PairGameEasy {
	static int x, y;
	static boolean flag = false;

	public static void dfs(int a, int b) {
		if (flag)
			return;
		if (a > x || b > y)
			return;
		if (a == x && b == y) {
			flag = true;
			return;
		}
		dfs(a + b, b);
		dfs(a, a + b);
	}

	public static String able(int a, int b, int c, int d) {
		x = c;
		y = d;
		int a1 = a;
		int b1 = b;
		dfs(a, b);

		return flag ? "Able to generate" : "Not able to generate";
	}

	public static void main(String args[]){
		System.out.println(able(1,1,999,100));
	}

}
