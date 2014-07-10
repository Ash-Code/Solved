package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

/*
 ID: renegad2
 LANG: JAVA
 TASK: rec1
 */
public class rect1 {
	public static PrintWriter pw;

	public static class region {
		int llx, lly, urx, ury;
		int n;

		public region(int a, int b, int c, int d) {
			llx = a;
			lly = b;
			urx = c;
			ury = d;
			n = (c - a + 1) * (d - b + 1);
		}
	}

	public static int intersect(region a, region b) {
		
		
		return 0;
	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		Scanner ss = new Scanner(bf);
		int A = ss.nextInt();
		int B = ss.nextInt();
		int n = ss.nextInt();
		region list[] = new region[n];
		for (int i = 0; i < n; i++) {
			list[i] = new region(ss.nextInt(), ss.nextInt(), ss.nextInt()-1,
					ss.nextInt()-1);
		}

		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {

			}
		}

		st.nextToken();
		pw.close();
		System.out.println("time :" + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
