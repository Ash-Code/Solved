package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class T1012Kbased2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[n + 1];
		// Dynamic
		dp[1] = k - 1;
		dp[2] = k * (k - 1);// init
		BigInteger x = BigInteger.valueOf(dp[1]);
		BigInteger y = BigInteger.valueOf(dp[2]);
		BigInteger ans = null;
		String res = "";
		for (int i = 3; i <= n; i++) {
			ans = x.add(y).multiply(BigInteger.valueOf(k - 1));
			x = y;
			y = ans;
		}
		if (n == 1 || n == 2)
			System.out.println(dp[n]);
		else
			System.out.print(ans.toString());
	}
}