package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

/*
 ID: renegad2
 LANG: JAVA
 TASK: stamps
 */
public class stamps {
	public static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int k = (int) st.nval;
		st.nextToken();
		int n = (int) st.nval;
		int[] stamps = new int[n];
		int[] dp = new int[200 * 10000 + 1];
		for (int i = 0; i < n; i++) {
			st.nextToken();
			stamps[i] = (int) st.nval;

		}
		Arrays.sort(stamps);
		dp[0] = 0;
		int last = 0;

		int min = 0;
		while (min <= k) {
			++last;
			min = k + 1;
			for (int x : stamps) {
				if (last - x >= 0) {
					min = Math.min(min, dp[last - x] + 1);
				}
			}
			dp[last] = min == k + 1 ? 0 : min;
		}

//		for (int i = 1; i < 20; i++) {
//			int x = dp[i];
//			System.out.print(x + " ");
//		}
		--last;
		System.out.println(last);
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
