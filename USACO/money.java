package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
 ID: renegad2
 LANG: JAVA
 TASK: money
 */
public class money {
	public static PrintWriter pw;
	public static long[][] dp;
	public static int[] vals;

	public static long iterate(int N, int lim) {

		for (int n = 0; n <= N; n++) {
			for (int l = lim-1; l >= 0; l--) {
				if (n == 0) {
					dp[n][l] = 1;// here is where it starts "picking" its value, i.e. base case. 
				} else {
					dp[n][l] = 0;
					for (int i = 0; i <= l; i++) {
						if (n - vals[i] >= 0) {
							dp[n][l] += dp[n - vals[i]][i];
						}

					}

				}

			}
			
		}

		return dp[N][lim-1];

	}

		
	public static long easy(int N){
		long[] mem=new long[N+1];
		mem[0]=1;
		for(int i=0;i<vals.length;i++){
			System.out.println(" i : "+i+" val "+vals[i]);
			for(int c=vals[i];c<=N;c++){
				mem[c]+=mem[c-vals[i]];
				System.out.println("            sum : "+c+" = "+mem[c]+" added "+mem[c-vals[i]]+" from : "+(c-vals[i]));
			}
		}
		return mem[N];
	}
	
	
	
	public static long rec(int N, int lim) {
		if (dp[N][lim] != -1)
			return dp[N][lim];

		if (N == 0)
			return 1;

		long ways = 0;
		for (int i = 0; i <= lim; i++) {
			if (N - vals[i] >= 0) {
				ways += rec(N - vals[i], i);
			}
		}
		dp[N][lim] = ways;

		return dp[N][lim];
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int V = (int) st.nval;
		st.nextToken();
		int N = (int) st.nval;
		vals = new int[V];
		for (int i = 0; i < V; i++) {
			st.nextToken();
			vals[i] = (int) st.nval;
		}
		long time = System.currentTimeMillis();

		dp = new long[N + 1][V + 1];
		for (int i = 0; i < N + 1; i++)
			Arrays.fill(dp[i], -1);

		
		System.out.println(iterate(N,V));
		pw.close();
		System.out.println(easy(30));
		System.out.println("Time : " + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
