package timus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class T1296 {
	static PrintWriter pw;

	public static void Solve() {

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int N = (int) st.nval;
		int in[] = new int[N];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			in[i] = (int) st.nval;
		}
		
		int dp[][] =new int[N][N];
		for(int i=0;i<N;i++)
			dp[i][i]=in[i];
		int max = 0, s = 0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				dp[i][j]=dp[i][j-1]+in[j];
				if(dp[i][j]>max){
					max=dp[i][j];
				}
			}
		}
		
		/*
		
		for (int i = 0; i < N; i++) {
			s += in[i];
			if (s < 0)
				s = 0;
			max = Math.max(s, max);
		}
*/
		pw.println(max);

		bf.close();

		pw.close();
		System.exit(0);

	}
}