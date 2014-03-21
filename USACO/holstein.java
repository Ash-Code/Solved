package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.TreeSet;

/*
 ID: renegad2
 LANG: JAVA
 TASK: holstein
 */

// Simple adhoc problem solvable by brute force
// the USACO analysis is a recursive solution. Much simpler though harder to implement;
public class holstein {

	// You can only save the choices in an int or long if the choices lie b/w
	// 0-9 and total number is "less" than 20 (considering you want them sorted
	// lexicographically
	// If the number or choices is larger than 20, but still between 0-9, store
	// them in a string that compares lexicographically which is similar to
	// value comparison on numbers

	public static class node implements Comparable<node> {

		ArrayList<Integer> list = new ArrayList<Integer>();

		@Override
		public int compareTo(node n) {
			if (n.list.size() > list.size())
				return -1;
			if (n.list.size() < list.size())
				return 1;
			for (int i = 0; i < n.list.size(); i++) {// this method sorts similar length lists on the basis of lower value first
				if (n.list.get(i) > list.get(i))
					return -1;
				if (n.list.get(i) < list.get(i))
					return +1;
			}

			return 0;
		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int V = (int) st.nval;
		int[] req = new int[V];
		for (int i = 0; i < V; i++) {
			st.nextToken();
			req[i] = (int) st.nval;
		}

		st.nextToken();
		int G = (int) st.nval;
		int[][] map = new int[G][V];
		for (int i = 0; i < G; i++) {
			for (int j = 0; j < V; j++) {
				st.nextToken();
				map[i][j] = (int) st.nval;
			}
		}

		TreeSet<node> set = new TreeSet<node>();
		int t = 1 << (G + 1);
		int temp[] = new int[V];
		ytre: for (int i = 1 << G; i < t; i++) {
			temp = new int[V];
			node n = new node();

			for (int j = 0; j < G; j++) {
				if ((i & 1 << j) == 1 << j) {

					n.list.add(j + 1);
					for (int x = 0; x < V; x++) {
						temp[x] += map[j][x];
					}
				}

			}

			for (int x = 0; x < V; x++) {

				if (temp[x] < req[x])
					continue ytre;
			}
			set.add(n);
		}
		node x = set.pollFirst();

		pw.print(x.list.size() + " ");
		for (int i = 0; i < x.list.size() - 1; i++)
			pw.print(x.list.get(i) + " ");

		pw.println(x.list.get(x.list.size() - 1));
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);

	}
}
