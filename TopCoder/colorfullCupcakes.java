package TopCoder;

import java.util.Arrays;

public class colorfullCupcakes {
	static int mod = (int) (1e9) + 7;
	static int start;
	static int dp[][][][][];

	public static int rec(int A, int B, int C, int first, int Last) {
		if (A < 0 || B < 0 || C < 0)
			return 0;

		if (dp[A][B][C][first][Last] != -1) {
			return dp[A][B][C][first][Last] % mod;
		}

		if (A == 0 && B == 0 && C == 0) {
			if (Last != first) {
				return 1;

			} else
				return 0;
		}
		int res = 0;
		if (Last == 0) {
			res += (rec(A, B - 1, C, first, 1) % mod);
			res %= mod;
			res += (rec(A, B, C - 1, first, 2) % mod);
			res %= mod;
		} else if (Last == 1) {
			res += (rec(A - 1, B, C, first, 0) % mod);
			res %= mod;
			res += (rec(A, B, C - 1, first, 2) % mod);
			res %= mod;
		} else if (Last == 2) {
			res += (rec(A - 1, B, C, first, 0) % mod);
			res %= mod;
			res += (rec(A, B - 1, C, first, 1) % mod);
			res %= mod;
		}
		dp[A][B][C][first][Last] = res % mod;

		return dp[A][B][C][first][Last] % mod;
	}

	public static int number(String in) {
		int A = 0, B = 0, C = 0;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == 'A')
				A++;
			if (in.charAt(i) == 'C')
				C++;
			if (in.charAt(i) == 'B')
				B++;
		}
		dp = new int[A + 1][B + 1][C + 1][3][3];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				for (int k = 0; k <= C; k++) {
					for (int l = 0; l < 3; l++) {

						Arrays.fill(dp[i][j][k][l], -1);

					}
				}
			}
		}

		start = 0;
		int res = 0;
		res += (rec(A - 1, B, C, 0, 0) % mod);
		res %= mod;
		start = 1;
		res += (rec(A, B - 1, C, 1, 1) % mod);
		res %= mod;
		start = 2;
		res += (rec(A, B, C - 1, 2, 2) % mod);
		res %= mod;
		return res;
	}

	public static void main(String args[]) {
		System.out.println(number("BCBABBACBABABCCCCCAABBAACBBBBCBCAAA"));
	}

}
