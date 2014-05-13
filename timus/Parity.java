package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parity {

	public static class inter {
		int s, e, p;

		public inter(int a, int b, int p) {
			s = a;
			e = b;
			this.p = p;
		}

		@Override
		public boolean equals(Object x) {
			if (!(x instanceof inter)) {
				return false;
			}
			inter i = (inter) x;
			if (i.s == this.s && i.e == this.e)
				return true;
			else
				return false;
		}

		@Override
		public int hashCode() {
			return this.s + this.e;
		}
	}

	public static int Solve(ArrayList<inter> list, int N) {
		boolean flag = true;
		ArrayList<inter> proc = new ArrayList<inter>();
		HashMap<inter, Integer> map = new HashMap<inter, Integer>();
		int lim2 = 0, lim1 = 0;
		lim2 = lim1 = list.size();
		int i = 0;
		next: for (i = 0; i < lim1; i++) {
			flag = true;
			inter t = list.get(i);
			if (t.s < 0 || t.e > N) {
				flag = false;
				break;
			}
			if (!map.containsKey(t)) {
				System.out.println("base added " + t.s + " " + t.e + " " + t.p);
				proc.add(t);
				map.put(t, t.p);
			} else {
				if (map.get(t) != t.p)
					break;
			}

			lim2 = proc.size();
			for (int j = 0; j < lim2; j++) {
				inter temp = proc.get(j);
				inter curr=t;
				if (temp.s == t.e + 1)
					curr = (new inter(t.s, temp.e, t.p ^ temp.p));
				else if (temp.e + 1 == t.s)
					curr = (new inter(temp.s, t.e, t.p ^ temp.p));

				if (!map.containsKey(curr)) {
					map.put(curr, curr.p);
					proc.add(curr);
					System.out.println("     Interval Added " + curr.s + " " + curr.e + " " + curr.p);
				} else {
					if (map.get(curr) != curr.p)
						break next;
				}
			}

		}

		return i;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter((System.out));

		HashMap<inter, Integer> map = new HashMap<inter, Integer>();
		int res = 0;
		while (true) {

			int N = Integer.parseInt(bf.readLine());
			if (N < 0)
				break;
			int m = Integer.parseInt(bf.readLine());

			 System.out.println("GOING " + N + " " + m);
			ArrayList<inter> list = new ArrayList<inter>();
			next: for (int i = 0; i < m; i++) {

				Scanner ss = new Scanner(bf.readLine());
				int s = ss.nextInt();
				int e = ss.nextInt();

				// System.out.println("  "+s+ " "+e+" "+st.sval);
				int p = ss.next().equals("even") ? 0 : 1;
				inter curr = new inter(s, e, p);
				list.add(curr);
				// System.out.println("base added " + s + " " + e + " " + p);

			}

			res = Solve(list, N);
			System.out.println(res);
		}
		bf.close();
		out.close();

	}

}
