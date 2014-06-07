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
 TASK: runaround
 */
public class inflate {
	public static PrintWriter pw;
public static int[] dp;


	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int M = (int) st.nval;
		st.nextToken();
		int n = (int) st.nval;
		int[] t = new int[n];
		int[] s=new int[n];
		for (int i = 0; i < n; i++) {
			st.nextToken();
			s[i]=(int)st.nval;
			st.nextToken();
			t[i] = (int) st.nval;
		}
		int best=0;
		dp=new int[M+1];
		dp[0]=0;
		for(int i=0;i<n;i++){
			for(int j=t[i];j<=M;j++){
				dp[j]=Math.max(dp[j], dp[j-t[i]]+s[i]);
			}
		}
		pw.println(dp[M]);
		
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
