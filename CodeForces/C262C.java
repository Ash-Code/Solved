package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C262C {
	FastScanner in;
	PrintWriter out;
	BufferedReader bf;

	public void Solve() {
		int n = in.nI();
		int m = in.nI();
		int w = in.nI();
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nL();
		}
		long lo = 0, hi = (long) 1e10;
		while (hi - lo > 1) {
			long mid = hi + lo >> 1;
			long Water = m;
			int pos = 0;
			for (; pos < n; pos++) {
				if (a[pos] < mid) {
					int s = pos;
					long min = a[pos];
					for (; pos < s + w && pos < n; pos++) {
						min = Math.min(a[pos], min);
					}

					Water -= (mid - min);
				}
			}

			if (Water <= 0)
				hi = mid;
			else
				lo = mid;

		}

	}

	void run() {

		in = new FastScanner(System.in);
		out = new PrintWriter(System.out);
		
		Solve();

		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return null;
				st = new StringTokenizer(s);
			}
			return st.nextToken();
		}

		boolean hasMoreTokens() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		int nI() {
			return Integer.parseInt(next());
		}

		double nD() {
			return Double.parseDouble(next());
		}

		long nL() {
			return Long.parseLong(next());
		}
	}

	public static void main(String[] args) {
		Frame temp=new Frame();
		temp.run();
	}
}