package timus;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class T1018BinaryAT {
	static int[] dp;
	static int n;
	static int[] parent;

	public static class node implements Comparable<node> {
		int id, a, t;

		public node(int x, int y, int z) {
			id = x;
			a = y;
			t = z;
		}

		@Override
		public int compareTo(node v) {
			if (v.t > t)
				return -1;
			if (v.t < t)
				return 1;
			if (v.id > id)
				return -1;
			if (v.id < id)
				return 1;
			else
				return 0;
		}
	}

	public static int dfs(int a, int[][] map) {
		if (dp[a] != -1)
			return dp[a];
		int res = 0;
		dp[a] = 0;
		for (int i = 1; i <= n; i++) {
			if (map[a][i] != -1) {
				if (dp[i] != -1) {
					res += map[a][i];
					parent[a] = i;
				}
				if (dp[i] == -1)
					res += dfs(i, map);
			}
		}
		dp[a] = res;

		return res;

	}

	public static void main(String args[]) {

		Scanner ss = new Scanner(System.in);
		n = ss.nextInt();
		int q = ss.nextInt();
		int[][] map = new int[n + 1][n + 1];
		dp = new int[n + 1];
		parent = new int[n + 1];
		Arrays.fill(dp, -1);
		for (int i = 0; i <= n; i++)
			Arrays.fill(map[i], -1);
		int[] br = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			int a = ss.nextInt();
			int b = ss.nextInt();
			int c = ss.nextInt();
			br[a]++;
			br[b]++;
			map[a][b] = c;
			map[b][a] = c;
		}
		int start = 0;
		for (int i = 0; i <= n; i++)
			if (br[i] == 2) {
				start = i;
				break;
			}
		parent[start] = start;
		// System.out.println(start);
		int total = dfs(start, map);
		for (int i = 1; i <= n; i++)
			System.out.println(i + " " + dp[i]);
		
		
		
		System.out.println((total));

	}
}
