package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/*
ID: renegad2
LANG: JAVA
TASK: numtri
*/

public class numtri {

	static int sum = 0, max = 0, N;
	static int[][] tri;

	public static void dfs(int l, int pos) {

		if (l == N - 1) {
			sum += tri[l][pos];
			if (sum > max)
				max = sum;
			sum -= tri[l][pos];
			return;
		}

		sum += tri[l][pos];
		dfs( l + 1, pos);
		dfs(l + 1, pos + 1);
		sum -= tri[l][pos];

	}
	
	public static int Solve(){
		for(int i=N-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				tri[i][j]=tri[i][j]+Math.max(tri[i+1][j], tri[i+1][j+1]);
			}
		}
		return tri[0][0];
		
		
		
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));

		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		
		N = (int) st.nval;
		
		tri = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				st.nextToken();
				tri[i][j] = (int) st.nval;

			}
		}
		
		
		System.out.println(Solve());

	
		pw.close();

		System.exit(0);
	}

}
