package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

/*
 ID: renegad2
 LANG: JAVA
 TASK: concom
 */
public class temp {
	public static PrintWriter pw;
	public static int[][] map;
	public static ArrayDeque<Integer> q = new ArrayDeque<Integer>();
	static int N;

	public static class pair implements Comparable<pair> {
		int a, b;

		public pair(int x, int y) {
			a = x;
			b = y;
		}

		public int compareTo(pair x) {
			if (x.a > this.a)
				return -1;
			if (x.a < this.a)
				return 1;
			if (x.b > this.b)
				return -1;
			if (x.b < this.b)
				return 1;
			if (x.a == x.b)
				return 0;
			else
				return 0;
		}

	}

	public static TreeSet<pair> list = new TreeSet<pair>();

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		N = (int) st.nval;
		map = new int[100 + 1][100 + 1];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			int x = (int) st.nval;
			st.nextToken();
			int y = (int) st.nval;
			st.nextToken();
			int p = (int) st.nval;
			if (x == y)
				map[x][y] = 0;
			else
				map[x][y] = p;
		}

		for (int i = 1; i <= 100; i++) {
			boolean found = false;
			boolean visited[] = new boolean[101];
			Arrays.fill(visited, false);
			q = new ArrayDeque<Integer>();
			for (int j = 1; j <= 100; j++) {
				if (map[i][j] > 50) {
					q.add(j);
					visited[j] = true;
					list.add(new pair(i, j));
					found = true;
				}

			}

			if (found) {

				int[] perc;
				int j = 0;
				while (found) {
					perc = new int[101];
					found = false;
					q.add(i);
					for (int x : q) {
						for (int k = 1; k <= 100; k++)
							perc[k] += map[x][k];
					}
					for (int k = 1; k <= 100; k++) {
						if (perc[k] > 50) {
							if (!visited[k]) {
								visited[k] = true;
								q.add(k);
								found = true;
							}

						}
					}

				}

				for (int k = 1; k <= 100; k++)
					if (visited[k])
						list.add(new pair(i, k));

			}
			q.clear();

		}

		for (pair x : list) {
			if (x.a != x.b)
				pw.println(x.a + " " + x.b);
		}

		pw.close();
		System.out.println("Time : " + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
