package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C263D {
	FastScanner in;
	PrintWriter out;
	BufferedReader bf;
	final int MOD = (int) 1e9 + 7;

	public class node {
		int id;
		long dp0;
		long dp1;
		int color;
		boolean visited;
		ArrayList<Integer> edges;

		public node(int i) {
			id = i;
			dp0 = -1;
			dp1 = -1;
			color = 0;
			visited = false;
			edges = new ArrayList<Integer>();
		}

	}

	class FastScanner {
		public node[] nodes;
		
		public long rec(int s, int p, int c) {

			if (nodes[s].visited) {
				return c == 0 ? nodes[s].dp0 : nodes[s].dp1;
			}
			nodes[s].visited = true;
			long dp1 = 0;
			long dp0 = 0;
			if (nodes[s].color == 0) {
				dp1 = 0;
				dp0 = 1;
				for (int x : nodes[s].edges) {
					dp1 *= (rec(x, s, 0) + rec(x, s, 1));
					dp1 %= MOD;
					dp1 += (dp0 * rec(x, s, 1));
					dp1 %= MOD;
					dp0 *= (rec(x, s, 1) + rec(x, s, 0));
					dp0 %= MOD;
				}

			} else {
				dp1 = 1;
				dp0 = 0;
				for (int x : nodes[s].edges) {

					dp1 *= (rec(x, s, 0) + rec(x, s, 1));
					dp1 %= MOD;

				}
			}
			nodes[s].dp0 = dp0;
			nodes[s].dp1 = dp1;
			return c == 0 ? nodes[s].dp0 : nodes[s].dp1;
		}

		public void Solve() {
			int n = ni();
			nodes = new node[n];

			for (int i = 0; i < n; i++)
				nodes[i] = new node(i);

			for (int i = 0; i < n - 1; i++) {
				int a = ni();
				int b = i + 1;
				nodes[a].edges.add(b);

			}
			for (int i = 0; i < n; i++) {
				int c = ni();
				nodes[i].color = c;
			}
			long res = 0;
			res = rec(0, -1, 1);
			System.out.println(res);

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
		new C263D().run();
	}
}