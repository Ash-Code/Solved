package timus;

import java.util.Scanner;

public class Staircases {

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		long[][] dp = new long[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			dp[i][i] = 1;

		for (int i = 1; i <= n; i++) {
			for (int h = 1; h <= i; h++) {
				int k = h + 1;
				while (i + k <= n) {//wooooohooo!
					dp[i + k][k] += dp[i][h];
					k++;
				}
			}
		}

		long res = 0;
		for (int i = 1; i < n; i++)
			res+=(dp[n][i]);
		System.out.println(res);
	}

}
