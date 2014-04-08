package CodeProbs;

import java.io.IOException;
import java.util.Scanner;

public class SquareCountry {

	public static int lands(int a) {
		int dp[] = new int[60001];
		int s;
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 2; i <= a; i++)
			dp[i] = a;
		for (int quads = 2; quads <= a; quads++) {
			for (int i = 0; (s = i * i) <= quads; i++) {
				dp[quads] = Math.min(dp[quads], dp[quads - s] + 1);

			}
		}
		return dp[a];

	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int q = (int) s.nextInt();
		System.out.print(lands(q));
	}
}
