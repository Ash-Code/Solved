package timus;

import java.util.Scanner;
import java.util.TreeSet;

public class T1024Permutaions {
	static boolean done[];
	static int map[];

	public static long gcd(long a, long b) {
		if (a < b)
			return gcd(b, a);
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		return ((a * b) / gcd(a, b));

	}

	public static long lcmofarray(long[] arr, int start, int end) {// finding the
																	// LCM of an
																	// array
		if ((end - start) == 1)
			return lcm(arr[start], arr[end - 1]);
		else
			return (lcm(arr[start], lcmofarray(arr, start + 1, end)));
	}

	public static int dfs(int root, int child) {
		// System.out.println(root + " " + child);
		if (root == child)
			return 1;
		// done[child] = true;
		return 1 + dfs(root, map[child]);
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		map = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = ss.nextInt();
		}
		done = new boolean[n + 1];

		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 1; i <= n; i++) {
			set.add(dfs(i, map[i]));
		}
		long[] list = new long[set.size()];
		int p = 0;
		for (int x : set) {
			list[p] = x;
			p++;
		}
		long res = lcmofarray(list, 0, list.length);

		System.out.println(res);
	}
}
