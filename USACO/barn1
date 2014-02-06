

/*
 ID: renegad2
 LANG: JAVA
 TASK: barn1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class barn1 {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"barn1.out")));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] occ = new int[n];

		StreamTokenizer s = new StreamTokenizer(bf);
		for (int i = 0; i < n; i++) {
			s.nextToken();
			occ[i] = (int) s.nval;
		}
		int[] diff = new int[n - 1];
		Arrays.sort(occ);
		for (int i = 1; i < n; i++) {
			diff[i - 1] = occ[i] - occ[i - 1] - 1;
		}

		Arrays.sort(diff);
		Arrays.sort(occ);
		int D= occ[occ.length-1]-occ[0]+1;
		if(N>=n){
		pw.println(n);
		}else{
		int x = diff.length - 1;
		for (int i = 0; i < N-1; i++) {
			D-= diff[x];
			x--;
		}

		pw.println(D);
}
		pw.close();
		System.exit(0);
	}
}
