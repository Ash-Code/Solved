package CodeProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Metro {

	public static void input() throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		int N, M, K, coords[][];

		st.nextToken();

		N = (int) st.nval;
		st.nextToken();

		M = (int) st.nval;
		st.nextToken();

		K = (int) st.nval;
	
		coords = new int[K][2];
		for (int i = 0; i < K; i++) {
			st.nextToken();
			coords[i][0] = (int) st.nval;
			st.nextToken();
			coords[i][1] = (int) st.nval;

		}

		System.out.println(shortest(N, M, K, coords));
	}

	public static long shortest(int N, int M, int K, int[][] coords) {
		int endx = N + 1, endy = M + 1;
		long result;

		double dp[][] = new double[N + 1][M + 1];
		final double costdiag = Math.pow(20000, 0.5);
		final double cost = 100;
		int[][] k = new int[endx][endy];
		boolean change = true, can[][] = new boolean[endx][endy];
		for (int i = 0; i < endx; i++) {
			for (int j = 0; j < endy; j++) {
				dp[i][j] = 5000000;
				k[i][j] = 0;
				can[i][j] = false;
			}
		}
		dp[0][0] = 0;

		for (int i = 0; i < K; i++) {
			can[coords[i][0]][coords[i][1]] = true;
		}
		
		
		double minleft = 5000000, mindown = 5000000, mindiag = 5000000, min = 0, lastVal = 0;
		while (change) {

			for (int i = 0; i < endx; i++) {
				for (int j = 0; j < endy; j++) {
					minleft = mindown =  mindiag = 5000000;
					min=0;

					lastVal = dp[N][M];

					if (i > 0 && j > 0) {
						if (can[i][j] == true && k[i][j] < K) {
							mindiag = dp[i - 1][j - 1] + costdiag;
						}
					}

					if (i > 0) {
						minleft = dp[i - 1][j] + cost;

					}
					if (j > 0) {
						mindown = dp[i][j - 1] + cost;
					}
					min = Math.min(minleft, mindown);
					min = Math.min(min, mindiag);
					dp[i][j] = Math.min(dp[i][j], min);
					if (min == mindiag && min!=5000000) {
						k[i][j]++;
						
					}

					if (lastVal < 500000 && lastVal == dp[N][M]) {
						change = false;
					}
					
				}
			}
		}

		result = Math.round(dp[N][M]);

		return result;

	}

	public static void main(String args[]) throws IOException {
		input();
	}

}
