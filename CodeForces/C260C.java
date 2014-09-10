package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class C260C {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		long[] a = new long[1000002];
		int max = 0;
		for (int i = 0; i < n; i++) {
			st.nextToken();
			int x = (int) st.nval;
			max = Math.max(x, max);
			a[x]++;
//			System.out.println("taking");
		}
//		System.out.println("reached");
		long[] dp = new long[max + 1];
		dp[1] = a[1] * 1;
		dp[2] = Math.max(dp[1], 2 * a[2]);
		for (int i = 3; i <= max; i++) {
//			System.out.println("doing");
			dp[i] = Math.max(dp[i - 3] + i * a[i],
					Math.max(dp[i - 2] + i * a[i], dp[i - 1]));
		}
		System.out.println(dp[max]);

	}

}
