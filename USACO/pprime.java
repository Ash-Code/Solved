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
 TASK: pprime
 */

public class pprime {
	static int A = 0, B = 0;
	static PrintWriter pw;

	public static void check(int a) {
		if (a > B || a < A)
			return;
		int lim = (int) Math.sqrt(a);
		boolean p = true;
		for (int i = 3; i <= lim; i++) {
			if (a % i == 0) {
				p = false;
				break;
			}
		}

		if (p)
			pw.println(a);
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));

		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		A = (int) st.nval;
		st.nextToken();
		B = (int) st.nval;
		int t = B;
		int du = 0, dl = 0;
		while (t > 0) {
			t /= 10;
			du++;
		}
		t = A;
		while (t > 0) {
			t /= 10;
			dl++;
		}
		dl = dl % 2 == 0 ? dl / 2 : dl / 2 + 1;
		du = du % 2 == 0 ? du / 2 : du / 2 + 1;
		long time = System.currentTimeMillis();
		check(5);
		check(7);
		for (int d = dl; d <= du; d++) {

			for (int a = 1; a <= 9; a += 2) {
				if (a == 5 && d != 1)
					continue;
				if (d == 1) {
					check(a * 10 + a);
				}
				for (int b = 0; b <= 9; b++) {
					if (d == 2) {
						check(a * 100 + b * 10 + a);
						check(a * 1000 + b * 100 + b * 10 + a);
					}
					for (int c = 0; c <= 9; c++) {
						if (d == 3) {
							check(a * 10000 + b * 1000 + c * 100 + b * 10 + a);
							check(a * 100000 + b * 10000 + c * 1000 + c * 100
									+ b * 10 + a);
						}
						for (int e = 0; e <= 9; e++) {
							if (d == 4) {
								check(a * 1000000 + b * 100000 + c * 10000 + e
										* 1000 + c * 100 + b * 10 + a);
								check(a * 10000000 + b * 1000000 + c * 100000
										+ e * 10000 + e * 1000 + c * 100 + b
										* 10 + a);
							}

						}
					}
				}

			}
		}
		System.out.println(System.currentTimeMillis() - time);

		pw.close();

		System.exit(0);
	}

}
