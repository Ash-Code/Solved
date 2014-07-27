package timus;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryAppleTree {
	public static int[][] dp;
	static int[][] map;

	public static int dfs(int root, int parent, int branches) {
		if (branches == 0)
			return 0;
		if (branches == 1)
			return map[parent][root];
		if (dp[root][branches] != -1)
			return dp[root][branches];
		// consider the parent branch as the number of apples contained by the
		// node. The childs' apples with appropriate branches with the apples of
		// the node give us a temp sum maximum of which is the max apples
		// available at the node with said branches.
		int[] childs = new int[2];
		int c = 0;
		boolean found = false;
		for (int i = 1; i < map.length; i++) {
			if (i == parent)
				continue;
			if (map[root][i] != -1) {
				childs[c] = i;
				c++;
				found = true;
			}
		}
		if (!found)
			return map[parent][root];
		dp[root][branches] = 0;
		int max = 0;
		for (int i = 0; i < branches; i++) {
			int temp = map[parent][root] + dfs(childs[0], root, i)
					+ dfs(childs[1], root, branches - 1 - i);

			max = Math.max(temp, max);
		}
		dp[root][branches] = max;
		return dp[root][branches];

	}

	public static void main(String args[]) {

		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int q = ss.nextInt();
		dp = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(map[i], -1);
			Arrays.fill(dp[i], -1);
			dp[i][0] = 0;
		}
		for (int i = 0; i < n - 1; i++) {
			int a = ss.nextInt();
			int b = ss.nextInt();
			int c = ss.nextInt();
			map[a][b] = c;
			map[b][a] = c;
		}
		map[1][0] = 0;
		map[0][1] = 0;
		System.out.println(dfs(1, 0, q + 1));

	}

}
