package CodeProbs;

import java.util.Scanner;

public class Vasya {

	public static int Solve(int S) {
		int dp[][] = new int[11][82];
		int s = 0;
		for (int x = 1; x <= (9); x++)
			dp[1][x] = 1;

		for (int n = 2; n < 10; n++) {

			for (s = 0; s <= n * 9; s++) {
				for (int i = 0; i <= 9; i++) {
					dp[n][s] += ((s - i) >= 0 ? dp[n - 1][s - i] : 0);

				}

			}

		}
		s = 0;
		dp[10][1] = 1;
		for (int x = 1; x < 11; x++)
			s += dp[x][S];

		return s;

	}

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		
		s.close();
		System.out.println(Solve(a));
	}

}
