package CodeForces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;

class C233B {

	public static long[] h = new long[60];

	public static long hash(int l) {
		if (l == 0)
			return 0;
		if (l == 1) {
			return 1;
		}

		if (h[l] != 0)
			return h[l];

		return 2 * hash(l - 1) + 1;

	}

	public static BigInteger Solve(int n, String s) {
		BigInteger steps = BigInteger.valueOf(0);

		char[] in = s.toCharArray();
		boolean m[] = new boolean[in.length];
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 'R')
				m[i] = false;
			else
				m[i] = true;
		}

		boolean found = true;

		while (found) {

			found = false;
			steps = steps.add(BigInteger.valueOf(1));

			int i = 0;
			for (i = 0; i < in.length; i++) {

				if (m[i]) {

					found = true;
					m[i] = false;
					break;
				}

			}
			if (i != in.length)
				steps = steps.add(BigInteger.valueOf(hash(i)));

		}

		return steps.subtract(BigInteger.ONE);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		st.nextToken();
		String s = st.sval;
		System.out.println(Solve(s.length(), s).toString());

		pw.close();
		System.exit(0);

	}
}