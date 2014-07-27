package timus;

import java.util.Scanner;

public class T1009Kbased {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[n + 1];
		// Dynamic
		dp[1] = k - 1;
		dp[2] = k * (k - 1);// init
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);// the n-2 digits val will
														// have all non-zero
														// digits in its last
														// place. Hence exactly
														// these numbers can
														// have a zero in the
														// n-1th place.
		}
		System.out.print(dp[n]);
	}
}