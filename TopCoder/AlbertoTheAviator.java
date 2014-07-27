package TopCoder;

import java.util.Arrays;
import java.util.Comparator;

public class AlbertoTheAviator {

	public static class node {
		int d, r, dec;

		public node(int x, int y) {
			d = x;
			r = y;
			dec = d - r;
		}
	}

	static node list[];
	static int dp[][];
	static int N;

	public static int rec(int F, int i) {

		if (i >= N)
			return 0;

		if (dp[F][i] != -1)
			return dp[F][i];

		int ans = rec(F, i + 1);
		if (F - list[i].d >= 0)
			ans = Math.max(ans, 1 + rec(F - list[i].d + list[i].r, i + 1));

		dp[F][i] = ans;
		return dp[F][i];

	}

	public static int Solve(int F, int[] T, int[] R) {
		list = new node[T.length];
		for (int i = 0; i < T.length; i++) {
			list[i] = new node(T[i], R[i]);
		}
		Arrays.sort(list, new Comparator<node>() {

			@Override
			public int compare(node a1, node a2) {

				return a2.r - a1.r;
			}

		});
		dp = new int[F + 1][T.length];
		for (int i = 0; i <= F; i++)
			Arrays.fill(dp[i], -1);

		N = T.length;

		return rec(F, 0);
	}

	public static void main(String args[]) {
		int[] A = { 4, 8, 2, 1 };
		int[] B = { 2, 0, 0, 0 };

		System.out.println(Solve(12, A, B));

	}
}
