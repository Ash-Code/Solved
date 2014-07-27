package USACO;

/*
 ID: renegad2
 LANG: JAVA
 TASK: subsets
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/*Rather than pairs assume a sum to be reached, given as n*n+1/4 using some K nos. 
 * That sum can be split into cases with K-1 nos and Sum-K, or K-1 nos and Sum.
 * Trick was the initialization
 * the dp[0][i]=1 will help in making dp[j][i] when i>j
 * 
 */
public class Subsets {
	public static PrintWriter pw;

	public static long Solve(int N) {
		if (!((N + 1) % 4 == 0 || N % 4 == 0))
			return 0;
		long dp[][] = new long[(N * (N + 1) / 2) + 1][N + 1];

		for (int i = 0; i <= N; i++)
			dp[0][i] = 1;

		// state: sum of n using k numbers can be written as sum of n using k-1
		// nos, and sum of n-k using k-1 nos.
		// Iterative Solution

		for (int i = 1; i <= N; i++) {
			int max = (i * (i + 1) / 2);

			for (int j = 1; j <= max; j++) {

				if (i <= j)
					dp[j][i] = dp[j][i - 1] + dp[j - i][i - 1];
				else
					dp[j][i] = dp[j][i - 1];

			}
		}

		return dp[N * (N + 1) / 4][N]/2;
	}

	public static long Iterate(int N) {

		int sum=N*(N+1)/4;
		long[] dp=new long[sum+1];
		dp[0]=1;
		for(int i=1;i<=N;i++){
			System.out.println("N : "+i);
			for(int s=sum;s>=i;s--){
							dp[s]+=dp[s-i];
				System.out.println("     s: "+s+" = "+dp[s]+ " added "+dp[s-i]+" of "+(s-i));
			}
		}
		
		return dp[sum]/2;
	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		// System.out.println(Solve((int) st.nval) / 2);
		System.out.println(Iterate(7));
		System.out.println(Solve(7));
		pw.close();
		System.out.println("time :" + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
