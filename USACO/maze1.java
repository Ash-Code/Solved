package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 ID: renegad2
 LANG: JAVA
 TASK: maze1
 */
public class maze1 {
	
	//A really nice program. Combined graph theory with dynamic programming/memoization. 
	public static PrintWriter pw;
	public static boolean map[][];
	public static boolean visited[][];
	static int[][] dp;
	static int n, m;
	static int[] dx = { 0, 2, 0, -2 };
	static int[] dy = { 2, 0, -2, 0 };
	static int[] dx1 = { 0, 1, 0, -1 };
	static int[] dy1 = { 1, 0, -1, 0 };

	public static class node {
		int x, y, count;

		public node(int a, int b, int c) {
			x = a;
			y = b;
			count = c;
		}
	}

	public static int bfs(int i, int j) {
		ArrayDeque<node> q = new ArrayDeque<node>();
		q.add(new node(i, j, 0));
		int best = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			node c = q.pollFirst();

			if (c.x == n - 2 || c.x == 1 || c.y == m - 2 || c.y == 1) {//border check
				if (c.x == n - 2)
					if (!map[n - 1][c.y]) {
						best = Math.min(best, ++c.count);
						break;
					}
				if (c.x == 1)
					if (!map[0][c.y]) {
						best = Math.min(best, ++c.count);
						break;
					}
				if (c.y == 1)
					if (!map[c.x][0]) {
						best = Math.min(best, ++c.count);
						break;
					}
				if (c.y == m - 2)
					if (!map[c.x][m - 1]) {
						best = Math.min(best, ++c.count);
						break;
					}
			}

			for (int k = 0; k < 4; k++) {
				int nx = c.x + dx[k];
				int ny = c.y + dy[k];
				int cx = c.x + dx1[k];
				int cy = c.y + dy1[k];
				if (ny < m && ny >= 0 && nx < n && nx >= 0 && !visited[nx][ny]
						&& !map[cx][cy]) {
					if (dp[nx][ny] != -1) {//if we have already calculated the min dis from this point, no need to add it to the queue
						if (c.count + dp[nx][ny] < best)
							best = c.count + dp[nx][ny]+1;//just record the total min.
					} else
						q.add(new node(nx, ny, c.count + 1));

					visited[nx][ny] = true;//we'll mark it either ways
				}
			}

		}

		return best;

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		n = 2 * n + 1;
		m = 2 * m + 1;
		String[] in = new String[n];
		for (int i = 0; i < n; i++) {
			in[i] = bf.readLine();
		}

		map = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				if (in[i].charAt(j) == '+' || in[i].charAt(j) == '-'
						|| in[i].charAt(j) == '|') {
					map[i][j] = true;
				}
			}
		}

		int best = 0;
		dp = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			Arrays.fill(dp[i], -1);
		for (int i = 1; i < n; i += 2) {
			for (int j = 1; j < m; j += 2) {
				if (!map[i][j]) {
					visited = new boolean[n][m];
					int min = bfs(i, j);
					dp[i][j] = min;
					//System.out.println(i + " " + j + " res " + min);
					if (min > best) {
						best = min;
					}
				}

			}
		}
		pw.println(best);
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
