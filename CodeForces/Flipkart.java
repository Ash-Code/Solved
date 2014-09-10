package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Flipkart {
	static BufferedReader bf;
	static PrintWriter pw;

	public static long gcd(long a, long b) {
		if (a < b)
			return gcd(b, a);
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		// System.out.println("  called lcm " + a + " " + b);
		return ((a * b) / gcd(a, b));

	}

	public static long lcmRec(long[] arr, int start, int end) {// Recursively

		// finding LCM
		long res = 0;
		if ((end - start) == 1)
			res = lcm(arr[start], arr[end - 1]);
		else
			res = (lcm(arr[start], lcmRec(arr, start + 1, end)));

		return res;
	}

	public static String EqualLCM(long[] a, long[] b) {
		HashSet<Long> set = new HashSet<Long>();

		ArrayList<Long> x = new ArrayList<Long>();
		ArrayList<Long> y = new ArrayList<Long>();
		for (int start = 0; start < a.length; start++) {
			for (int end = start + 1; end < a.length; end++) {
				long res = lcmRec(a, start, end);
				if (set.contains(res))
					continue;
				set.add(res);
				x.add(res);
			}
		}
		set = new HashSet<Long>();
		for (int start = 0; start < b.length; start++) {
			for (int end = start + 1; end < b.length; end++) {
				long res = lcmRec(b, start, end);
				if (set.contains(res))
					continue;
				set.add(res);
				y.add(res);
			}
		}
		Collections.sort(x);
		Collections.sort(y);

		boolean equal = true;
		if (x.size() != y.size()) {
			return "Not Equal";
		}
		for (int i = 0; i < x.size(); i++) {
			if (x.get(i) != y.get(i)) {
				return "Not Equal";
			}
		}

		return "Equal";
	}

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		StreamTokenizer st = new StreamTokenizer(bf);
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = ss.nextLong();
		int n2 = ss.nextInt();
		long[] b = new long[n2];
		for (int i = 0; i < n2; i++) {
			b[i] = ss.nextLong();
		}
		System.out.println(EqualLCM(a, b));

		bf.close();
		pw.close();

	}
}
