package timus;

import java.util.Arrays;
import java.util.Scanner;

public class T1022Geneological {
	static int[][] map;
	static int[] dp;

	public static int dfs(int f) {
		if (dp[f] != -1)
			return dp[f];

		dp[f] = 0;

		for (int i = 1; i < map.length; i++) {
			if (map[f][i] == 1) {
				dp[f] += (1 + dfs(i));
			}
		}

		return dp[f];
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		map = new int[101][101];
		for (int i = 1; i <= n; i++) {
			int a = ss.nextInt();
			while (a != 0) {
				map[i][a] = 1;
				a = ss.nextInt();
			}
		}
		dp = new int[101];
		Arrays.fill(dp, -1);
		for (int i = 1; i <= n; i++) {
			if (dp[i] < 0) {
				dp[i] = dfs(i);
			}
		}
		boolean found = true;
		while (found) {
			int pos = 0, max = 0;
			found = false;
			for (int i = 1; i <= n; i++) {
				if (dp[i] >= max) {
					max = dp[i];
					pos = i;
					found = true;
				}

			}
			if (found) {
				System.out.print(pos+" ");
				dp[pos] = -1;
			}

		}

	}

}
