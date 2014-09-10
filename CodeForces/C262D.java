package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C262D {
	FastScanner in;
	PrintWriter out;
	BufferedReader bf;

	class FastScanner {

		public int msb(long x) {
			int pos = 0;
			while (x > 0) {
				x >>= 1;
				pos++;

			}
			return --pos;
		}

		public void Solve() {
			long l = nl();
			long r = nl();
			int k = ni();
			if (k == 1) {
				System.out.println(l);
				System.out.println(1);
				System.out.println(l);
			}
			if (k == 2) {
				if (r == l + 1) {
					if (l % 2 == 0) {
						System.out.println(l ^ r);
						System.out.println(2);
						System.out.println(l + " " + (l + 1));
					} else {
						if (l <= (l ^ r)) {
							System.out.println(l);
							System.out.println(1);
							System.out.println(l);
						} else {
							System.out.println(l ^ r);
							System.out.println(2);
							System.out.println(l + " " + r);
						}
					}
				} else {
					System.out.println(1);
					if (l % 2 != 0)
						l++;
					System.out.println(2);
					System.out.println(l + " " + (l + 1));
				}

			}

			if (k == 3) {

				int pos = msb(l);
				long min = ((long) 1 << (pos + 1)) | ((long) 1 << (pos));// BRACKET
																			// POSITION
																			// MATTERS
																			// (long)(1<<pos)
																			// will
																			// convert
																			// INTEGER
																			// to
																			// LONG
																			// coz
																			// bracket
																			// first
																			// encloses
																			// 1<<pos
				if (min <= r) {
					System.out.println(0);
					System.out.println(3);
					System.out.println(l + " " + min + " " + (l ^ min));
				} else {
					System.out.println(1);
					if (l % 2 != 0)
						l++;
					System.out.println(2);
					System.out.println(l + " " + (l + 1));
				}

			}

			if (k >= 4) {
				if (r - l + 1 == k && l % 2 != 0) {
					int pos = msb(l);
					long min = ((long) 1 << (pos + 1)) | ((long) 1 << (pos));
					if (min <= r) {
						System.out.println(0);
						System.out.println(3);
						System.out.println(l + " " + min + " " + (l ^ min));
					} else {
						System.out.println(1);
						if (l % 2 != 0)
							l++;
						System.out.println(2);
						System.out.println(l + " " + (l + 1));
					}
				} else {
					if (l % 2 != 0)
						l++;
					System.out.println(0);
					System.out.println(4);
					System.out.println(l + " " + (l + 1) + " " + (l + 2) + " "
							+ (l + 3));
				}
			}

		}

		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream f) {
			br = new BufferedReader(new InputStreamReader(f));
		}

		String n() {
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

		String l() {
			String s = null;
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;

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

		int nb() {
			return Integer.parseInt(n(), 2);
		}

		long nbl() {
			return Long.parseLong(n(), 2);
		}

		int ni() {
			return Integer.parseInt(n());
		}

		double nd() {
			return Double.parseDouble(n());
		}

		long nl() {
			return Long.parseLong(n());
		}
	}

	public void run() {
		in = new FastScanner(System.in);
		out = new PrintWriter(System.out);
		in.Solve();
		out.close();
	}

	public static void main(String[] args) {
		new C262D().run();
	}
}