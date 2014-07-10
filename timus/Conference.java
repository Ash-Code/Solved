package timus;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Conference {
	public static class node implements Comparable<node> {
		int s, e, l;

		public node(int x, int y) {
			s = x;
			e = y;
			l = y - x + 1;
		}

		@Override
		public int compareTo(node x) {
			if (x.e > e)
				return -1;
			if (x.e < e)
				return +1;
			if (x.s > s)
				return +1;
			if (x.s < s)
				return -1;
			return 0;
		}
	}

	public static void main(String args[]) {
		PrintWriter pw = new PrintWriter(System.out);
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		TreeSet<node> list = new TreeSet<node>();
		int s = Integer.MAX_VALUE, e = 0;
		for (int i = 0; i < n; i++) {
			int a = ss.nextInt();
			int b = ss.nextInt();
			if (a < s)
				s = a;
			if (b > e)
				e = b;
			list.add(new node(a, b));

		}
		int[] dp = new int[e + 1];
		node x = list.pollFirst();// 3 candidates!! dp[i-1], dp[i], dp[i-x.l]
		for (int i = s; i <= e; i++) {
			// System.out.println(x.s + " " + x.e);
			if (x.e == i) {
				while (x != null && x.e == i) {
					dp[i] = Math.max(dp[i - 1],
							Math.max(dp[i], dp[i - x.l] + 1));
					x = list.pollFirst();
				}
				// System.out.println("  at: " + i + " " + dp[i]);
			} else {
				dp[i] = dp[i - 1];
			}
		}
		// for(int i=0;i<=e;i++)
		pw.println(dp[e]);
		pw.close();
	}

}
