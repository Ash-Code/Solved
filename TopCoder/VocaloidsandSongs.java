package TopCoder;

import java.util.Arrays;

public class VocaloidsandSongs {
	 static long MOD = 1000000007; 
	public static long dp[][][][] = new long[51][51][51][51];

	public static int Solve(int S, int g, int m, int i) {
		if (S < 0 || g < 0 || m < 0 || i < 0)
			return 0;
		
		if (S == 0 && g == 0 && m == 0 && i == 0)
			return 1;

		if (dp[S][g][m][i] !=-1) {
		
			return (int)dp[S][g][m][i];
		}

		long res = Solve(S - 1, g - 1, m, i)%MOD + Solve(S - 1, g, m - 1, i)%MOD
				+ Solve(S - 1, g, m, i - 1)%MOD + Solve(S - 1, g - 1, m - 1, i)%MOD
				+ Solve(S - 1, g, m - 1, i - 1)%MOD + Solve(S - 1, g - 1, m, i - 1)%MOD
				+ Solve(S - 1, g - 1, m - 1, i - 1)%MOD;

		dp[S][g][m][i] = res%MOD;

		return (int)dp[S][g][m][i];

	}

		public static void main(String args[]) {
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				for(int k=0;k<dp[i][j].length;k++)
					Arrays.fill(dp[i][j][k], -1);
		System.out.println(Solve(50,25,25,25));
	}

}
