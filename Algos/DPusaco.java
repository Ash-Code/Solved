package CodingPrac;

public class DPusaco {

	static int best = 1;

	public static int DPI(int[] a) {
		int dp[] = new int[100];
		/*came up with the algo :
		 * if(c>dp[l])
		 * 		dp[l+1]=c;
		 * else see if it can improve a smaller length dp
		 */
		int l = 0;
		dp[0] = -1;
		for (int i = a.length - 1; i >= 0; i--) {
			int c = a[i];// take a candidate number

			if (c > dp[l]) { // if the highest length seq topmost val is
								// smaller, then assign this number as next
								// lengths top
				dp[l + 1] = c;
				l++;
			}
			if (c < dp[l]) {// otherwise update put it where it gives the
							// smallest top for a seq
				for (int j = l; j >= 0; j--) {
					if (dp[j] < c) {
						dp[j + 1] = c;
						break;
					}
				}

			}

		}

		for (int i = l; i >= 0; i--)
			System.out.println(i + " " + dp[i]);
		return l;

	}

	public static void rec(int a[], int pos, int better, int smallest) {

		if (pos >= a.length)
			return;

		if (better > best)
			best = better;

		for (int i = pos; i < a.length; i++) {
			if (a[i] < smallest)
				rec(a, i, better + 1, a[i]);
		}

	}

	
	public static void main(String args[]) {

		int[] a = { 1, 12, 9, 8, 3, 6, 5, 19, 2, 1, 4, 2, 0 };

		long time = System.currentTimeMillis();
		System.out.println("");
		System.out.println(DPI(a));
		System.out.println(System.currentTimeMillis() - time);
	}
}
