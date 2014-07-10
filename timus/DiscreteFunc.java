package timus;

import java.util.Scanner;

public class DiscreteFunc {
	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		long a = ss.nextLong();
		long maxinc = 0;
		int res1 = 1, res2 = 1;
		for (int i = 2; i <= n; i++) {
			long b = ss.nextLong();
			long t = Math.abs(b - a);
			if (t > maxinc) {
				maxinc = t;
				res1 = i - 1;
				res2 = i;
			}
			a = b;
		}
		System.out.println(res1 + " " + res2);
	}

}
