package CodeProbs;

import java.io.IOException;
import java.util.Scanner;

public class flags {
	public static void solve(int a) {
		long dp[][] = new long[a+1][2];
		dp[0][0]=dp[0][1]=0;
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i=2; i<=a;i++){
			dp[i][0] = dp[i-1][1]+ dp[i-2][1];
			dp[i][1] = dp[i-1][0]+dp[i-2][0];
			
		}
		
		System.out.println(dp[a][0]+dp[a][1]);

	}

	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		solve(a);
	}

}
