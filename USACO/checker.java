package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

/*
 ID: renegad2
 LANG: JAVA
 TASK: checker
 */

public class checker {
	public static PrintWriter pw;
	static int count = 0, cm = 0, col[];
	static boolean mid = false;
	public static Stack<Integer> s = new Stack<Integer>();
	public static int N;
	static long r, c, RD, LD;

	// bit masking is more efficient than boolean by a few secs; easier to
	// assign.
	// the cases were broken to half considering mirror image case. Mid rows
	// values is counted in case off odd rows upto half and then dfs ends.
	// VERY IMPORTANT : stack push and pop operation is expensive. Rather than that use an int array.

	public static void dfs(int l) {

		if (l == N) {
			count++;
			if (mid)
				cm++;
			if (count < 4) {
				pw.print(col[0] + 1);
				for (int i = 1; i < col.length; i++)
					pw.print(" " + (col[i] + 1));
				pw.println("");
			}
			return;
		}

		int lim = N - 1;
		if (l == 0 && N > 6)
			lim = (N - 1) / 2;

		for (int i = 0; i <= lim; i++) {
			if (l == 0 && i == (N - 1) / 2 && N % 2 != 0)
				mid = true;

			if ((RD & 1 << (i - l + N - 1)) == 0 && (LD & 1 << (l + i)) == 0
					&& (r & 1 << l) == 0 && (c & 1 << i) == 0) {

				RD |= 1 << (i - l + N - 1);
				LD |= 1 << (l + i);
				r |= 1 << l;
				c |= 1 << i;

				col[l] = i;
				dfs(l + 1);

				r &= ~(1 << l);
				c &= ~(1 << i);
				RD &= ~(1 << (i - l + N - 1));
				LD &= ~(1 << (l + i));

			}

		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		N = Integer.parseInt(bf.readLine());
		LD = 1 << ((2 * N) - 1);
		RD = 1 << ((2 * N) - 1);
		r = r << N;
		c = c << N;
		col = new int[N];
		dfs(0);
		if (N <= 6) {
			pw.println(count);
		} else
			pw.println(2 * (count - cm / 2));

		System.out.println(System.currentTimeMillis() - time);
		bf.close();

		pw.close();
		System.exit(0);

	}

}
