package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
 ID: renegad2
 LANG: JAVA
 TASK: numcows
 */
public class nocows {
	public static PrintWriter pw;
	public static int[][] dp;
	static int K;

	public static int rec(int N, int k) {

		if (N % 2 == 0)
			return 0;
		if (2 * k - 1 > N)

			return 0;

		if (k == 1)
			return N == 1 ? 1 : 0;

		if (dp[N][k] != -1)
			return dp[N][k];

		dp[N][k] = 0;

		for (int i = 1; i < (N + 1) / 2; i += 2) {

			int n1 = N - 1 - i;
			int n2 = i;
			int sol = 0;
			for (int j = 1; j < k - 1; j++) {

				sol += (rec(n1, k - 1) * rec(n2, j));
				sol += (rec(n1, j) * rec(n2, k - 1));
				sol %= 9901;
			}
			sol += rec(n1, k - 1) * rec(n2, k - 1);
			sol %= 9901;
			if (n1 != n2)
				dp[N][k] += (2 * sol);
			else
				dp[N][k] += sol;
			dp[N][k] %= 9901;

		}

		return dp[N][k];

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		st.nextToken();
		K = (int) st.nval;
		dp = new int[n + 1][K + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);

		System.out.println(rec(n, K));

		pw.close();
		System.out.println("Time: " + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
