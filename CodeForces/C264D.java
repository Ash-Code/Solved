package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C264D {
	FastScanner in;
	PrintWriter out;
	BufferedReader bf;

	class FastScanner {
		int[] lens;

		public int dfs(int s, ArrayList<Integer> curr,
				ArrayList<ArrayList<Integer>> list) {
			if (lens[s] != -1)
				return lens[s];
			if (curr.size() == 0)
				return 1;
			int res = 0;
			for (int x : curr) {
				res = Math.max(res, dfs(x, list.get(x), list) + 1);
			}
			lens[s] = res;

			return res;
		}

		public void Solve() {
			int n = ni();
			int K = ni();
			int[][] map = new int[K][n];
			HashMap<Integer, Integer> posF = new HashMap<Integer, Integer>();
			for (int k = 0; k < K; k++) {
				for (int i = 0; i < n; i++) {
					map[k][i] = ni();
					if (k == 0) {
						posF.put(map[k][i], i);
					}

				}
			}

			int[][] pos = new int[K][n];
			for (int k = 1; k < K; k++) {
				for (int i = 0; i < n; i++) {
					pos[k][posF.get(map[k][i])] = i;
				}
			}

//			for (int k = 0; k < K; k++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(pos[k][j] + " ");
//				}
//				System.out.println("");
//			}
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < n; i++) {
				list.add(new ArrayList<Integer>());

				for (int j = 0; j < i; j++) {
					boolean ok = true;
					for (int k = 1; k < K; k++) {
						if (pos[k][j] >= pos[k][i])
							ok = false;
					}
					if (ok)
						list.get(i).add(j);
				}

			}
			lens = new int[n];
			Arrays.fill(lens, -1);
			int res = 0;
			for (int i = n - 1; i >= 0; i--) {
				res = Math.max(res, dfs(i, list.get(i), list));
			}
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
		new C264D().run();
	}
}