package CodeForces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class C73C {

	static PrintWriter pw;

	public static long gcd(long a, long b) {
		if (a % b == 0)
			return b;

		return gcd(a, a % b);

	}

	public static void Solve() {

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int a = (int) st.nval;
		st.nextToken();
		int b = (int) st.nval;

		long aa = Math.max(a, b), bb = Math.min(a, b);
		long lim = aa * bb / gcd(aa, bb);

		long fa = lim / a;
		long fb = lim / b;
		if (a > b) {
			fa++;
		} else
			fb++;

		if (a == b) {
			pw.println("Equal");

		} else {
			if (fa > fb) {
				pw.println("Dasha");
			}
			if (fa < fb)
				pw.println("Masha");
			if (fa == fb)
				pw.println("Equal");
		}

		bf.close();

		pw.close();
		System.exit(0);

	}
}