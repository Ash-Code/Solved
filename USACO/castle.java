package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.TreeSet;

/*
 ID: renegad2
 LANG: JAVA
 TASK: castle
 */

public class castle {
	
	// First easily check the number of components and size of each,
	// then check for borders in the east and north direction only. 
	// order the results using treeset.
	
	public static int comp = 0, map[][], c[][], N, M, a;
	public static boolean[][] marked;

	public static class node implements Comparable<node> {/* best use for TreeSet, fast ordering but Since we need only the top answer
	Simple tagging would have sufficed. This takes time.
	*/
		int i, j, a;
		char d;

		public node(int i, int j, int a, char d) {
			this.i = i + 1;
			this.j = j + 1;
			this.a = a;
			this.d = d;
		}

		@Override
		public int compareTo(node t) {
			if (t.a > a)
				return 1;
			if (t.a < a)
				return -1;

			if (t.j > j)
				return -1;
			if (t.j < j)
				return 1;
			if (t.i > i)
				return 1;
			if (t.i < i)
				return -1;
			if (t.d == 'N')
				return 1;
			if (t.d == 'E')
				return -1;
			return 0;
		}

	}

	public static void dfs(int i, int j) {
	/* you don't need to create a node class for searching
	using DFS, recursing on the original map does the job,
	remember to mark visited areas
	*/
		if (marked[i][j])
			return;
		else
			marked[i][j] = true;

		a++;
		int t =map[i][j];

		c[i][j] = comp;

		if ((t & 1) == 0)
			dfs(i, j - 1);
		if ((t & 1 << 1) == 0)
			dfs(i - 1, j);
		if ((t & 1 << 2) == 0)
			dfs(i, j + 1);
		if ((t & 1<<3) == 0)
			dfs(i + 1, j);

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		M = (int) st.nval;
		st.nextToken();
		N = (int) st.nval;
		map = new int[N][M];
		c = new int[N][M];
		marked = new boolean[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				st.nextToken();
				map[i][j] = (int) st.nval;
			}

		
		HashMap<Integer, Integer> area = new HashMap<Integer, Integer>();
		a = 0;
		int max = 0;

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (!marked[i][j]) {
					comp++;
					a = 0;
					dfs(i, j);
					area.put(comp, a);
					if (a > max) {
						max = a;

					}
				}
			}
		
		TreeSet<node> set = new TreeSet<node>();

		for (int j = 0; j < M ; j++) {
			
			for (int i = N - 1; i >= 0; i--) {
				
				if ((i>0)&&c[i][j] != c[i - 1][j]) {
					set.add(new node(i, j, area.get(c[i][j])
							+ area.get(c[i - 1][j]), 'N'));
				}
				if ( (j<M-1) && c[i][j] != c[i][j + 1]) {
					set.add(new node(i, j, area.get(c[i][j])
							+ area.get(c[i][j + 1]), 'E'));
				}
			

			}

		}

		
		
		
		node n = set.pollFirst();
		pw.println(comp);
		pw.println(max);
		pw.println(n.a);
		pw.println(n.i + " " + n.j + " " + n.d);

		pw.close();
		

		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);

	}
}
