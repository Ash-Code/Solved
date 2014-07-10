package timus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class T1015TestDiff {
	public static class dice {
		int l, r, t, f, d, b;

		public dice(int a, int b, int c, int d, int e, int f) {
			l = a;
			r = b;
			t = c;
			this.f = d;
			this.d = e;
			this.b = f;
		}

		@Override
		public boolean equals(Object x) {
			if (!(x instanceof dice))
				return false;
			dice z = (dice) x;
			if (z.l == l && z.r == r && z.t == t && z.f == f && z.d == d
					&& z.b == b) {
				return true;
			} else
				return false;
		}

		@Override
		public int hashCode() {
			return l - r + t - f + d - b;
		}

	}

	public static dice rotateL(dice dd) {
		int l = dd.f;
		int r = dd.b;
		int t = dd.t;
		int f = dd.r;
		int d = dd.d;
		int b = dd.l;
		return new dice(l, r, t, f, d, b);
	}

	public static dice rotateT(dice dd) {
		int l = dd.l;
		int r = dd.r;
		int t = dd.f;
		int f = dd.d;
		int d = dd.b;
		int b = dd.t;
		return new dice(l, r, t, f, d, b);
	}

	public static dice rotateF(dice dd) {
		int l = dd.t;
		int r = dd.d;
		int t = dd.r;
		int f = dd.f;
		int d = dd.l;
		int b = dd.b;
		return new dice(l, r, t, f, d, b);
	}

	public static dice copy(dice dd) {
		return new dice(dd.l, dd.r, dd.t, dd.f, dd.d, dd.b);
	}

	public static void print(dice dd) {
		System.out.println(dd.l + " " + dd.r + " " + dd.t + " " + dd.f + " "
				+ dd.d + " " + dd.b);
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		HashSet<dice> set = new HashSet<dice>();
		dice[] list = new dice[n];
		for (int i = 0; i < n; i++) {
			list[i] = new dice(ss.nextInt(), ss.nextInt(), ss.nextInt(),
					ss.nextInt(), ss.nextInt(), ss.nextInt());
		}
		long time = System.currentTimeMillis();
		ArrayList<String> res = new ArrayList<String>();
		boolean used[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (used[i])
				continue;
			used[i] = true;
			set.clear();

			dice x = copy(list[i]);
			for (int left = 0; left < 4; left++) {
				x = rotateL(x);
				// set.add(x);
				// print(x);
				dice y = x;
				for (int top = 0; top < 4; top++) {
					y = rotateT(y);
					dice z = y;
					for (int f = 0; f < 4; f++) {
						z = rotateF(z);
						set.add(z);
					}

				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(i + 1);
			for (int j = i + 1; j < n; j++) {
				if (used[j])
					continue;
				if (set.contains(list[j])) {

					used[j] = true;
					sb.append(" " + (j + 1));
				}
			}
			res.add(sb.toString());

		}
		System.out.println(res.size());
		for (String s : res)
			System.out.println(s);
		ss.close();
		//System.out.println("time : " + (System.currentTimeMillis() - time));
	}
}
