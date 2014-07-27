package timus;

import java.util.Scanner;

public class T1029Ministry {

	static int[][] map;
	static long[][] dp;
	static int[][] track;

	public static long getMin(int level, int room) {
		long min = (long) 1e15;
		long bottom = 0;
		long top = 0;
		int pos = room + 1;
		int best=1000;
		while (pos < map[0].length) {// checking the Right cells for min value
			top += map[level][pos];// the chain of cells on the same level
			bottom += map[level - 1][pos - 1];// chain below the level, only 2
												// ways to reach a level in min
												// cost
			if (top + dp[level - 1][pos] < min) {
				track[level][room] = +(pos + 1);//tracking is 1 index based
				min = top + dp[level - 1][pos];
			}
			if (bottom + dp[level - 1][pos] < min) {
				track[level][room] = -(pos + 1);
				min = bottom + dp[level - 1][pos];
			}
			pos++;
		}
		pos = room - 1;
		bottom = 0;
		top = 0;
		while (pos >= 0) {// checking the left cells for min value
			top += map[level][pos];
			bottom += map[level - 1][pos + 1];
			if (top + map[level - 1][pos] < min) {
				track[level][room] = +(pos + 1);
				min = top + dp[level - 1][pos];
			}
			if (bottom + dp[level - 1][pos] < min) {
				track[level][room] = -(pos + 1);
				min = bottom + dp[level - 1][pos];
			}
			pos--;
		}

		if (min + map[level][room] >= map[level][room] + dp[level - 1][room])
			track[level][room] = -(room + 1);

		return Math.min(min + map[level][room], map[level][room]
				+ dp[level - 1][room]);
	}

	public static String print(int index, int M, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = M - 1; i > 0; i--) {
			sb.append(index + " ");

			int pos = index - 1;
			int val = Math.abs(track[i][pos]);
			if (track[i][pos] < 0 && -1 * track[i][pos] != index)
				sb.append(index + " ");

			// append all in between
			if (index != val) {
				if (val > index)
					for (int j = index + 1; j < val; j++)
						sb.append(j + " ");
				else
					for (int j = index - 1; j > val; j--)
						sb.append(j + " ");
			}

			// then check tracks

			if (track[i][pos] > 0)
				sb.append(val + " ");

			
			index = val;

		}
		sb.append(index + " ");
		sb.reverse();
		return sb.toString().trim();

	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int M = ss.nextInt();
		int N = ss.nextInt();
		map = new int[M][N];
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = ss.nextInt();

		dp = new long[M][N];
		track = new int[M][N];
		for (int i = 0; i < N; i++)
			dp[0][i] = map[0][i];
		for (int i = 1; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = getMin(i, j);

			}

		}
		int index = 0;
		long res = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (res >= dp[M - 1][i]) {
				res = dp[M - 1][i];
				index = i + 1;
			}
		}
		

		System.out.println(print(index, M, N));

	}

}
