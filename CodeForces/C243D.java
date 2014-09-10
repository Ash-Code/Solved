package CodeForces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.TreeSet;

public class C243D {
	static PrintWriter pw;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int x1, x2, y1, y2;

	public static class node2 implements Comparable<node2> {
		int x1, x2, y1, y2;
		int area;
		int count;
		int comp = 0;

		public node2(int a, int b, int c, int d, int cc, int comp) {
			x1 = a;
			x2 = b;
			y1 = c;
			y2 = d;
			area = (x2 - x1 + 1) * (y2 - y1 + 1);
			count = cc;
			this.comp = comp;
		}

		@Override
		public int compareTo(node2 aa) {
			if (aa.count > count)
				return -1;
			if (aa.count < count)
				return 1;

			if (aa.area > area)
				return -1;
			if (aa.area < area)
				return +1;

			if (aa.x1 > x1)
				return 1;
			if (aa.x1 < x1)
				return -1;
			if (aa.y1 < y1)
				return -1;
			if (aa.y1 > y1)
				return -1;
			if (aa.y2 < y2)
				return -1;
			if (aa.y2 > y2)
				return 1;
			return 0;
		}
	}

	public static class node {
		int x, y;

		public node(int a, int b) {
			x = a;
			y = b;

		}
	}

	public static int bfs(int i, int j, int comp) {
		ArrayDeque<node> q = new ArrayDeque<node>();
		q.add(new node(i, j));
		x1 = i;
		x2 = i;
		y1 = j;
		y2 = j;
		int count = 0;
		visited[i][j] = true;
		while (!q.isEmpty()) {
			node curr = q.pollFirst();
			count++;
			if (curr.x < x1)
				x1 = curr.x;
			if (curr.x > x2)
				x2 = curr.x;
			if (curr.y < y1)
				y1 = curr.y;
			if (curr.y > y2)
				y2 = curr.y;

			for (int l = 0; l < 4; l++) {
				int nx = curr.x + dx[l];
				int ny = curr.y + dy[l];
				if (nx < map.length && ny < map[0].length && nx >= 0 && ny >= 0
						&& map[nx][ny] == comp && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new node(nx, ny));
				}

			}

		}
		// System.out.println(x1+" "+x2+" "+y1+" "+y2);
		int area = (x2 - x1 + 1) * (y2 - y1 + 1);
		return (area - count);

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		st.nextToken();
		int m = (int) st.nval;
		st.nextToken();
		int k = (int) st.nval;
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				st.nextToken();
				map[i][j] = (int) st.nval;
			}
		}
		visited = new boolean[n][m];
		TreeSet<node2> set = new TreeSet<node2>();
		boolean flag = true;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j]) {
					continue;
				}
				int comp = map[i][j];
				int t=bfs(i,j,comp);
				System.out.println(i+" "+j+"   "+ t);
				set.add(new node2(x1, x2, y1, y2, comp, t));

			}
		}
		int count = 0;
		visited = new boolean[n][m];
		for (node2 x : set) {
			int comp = x.comp;
			System.out.println(x.x1 + " " + x.x2 + " " + x.y1 + " " + x.y2
					+ " " + x.area + " " + x.count);
			for (int i = x.x1; i <= x.x2; i++) {
				for (int j = x.y1; j <= x.y2; j++) {
					if (!visited[i][j] && map[i][j] != comp) {
						map[i][j] = comp;
						visited[i][j] = true;
						count++;
					}
				}
			}

			if (count > k) {
				flag = false;
				break;
			}

		}

		pw.println(flag ? count : -1);

		bf.close();

		pw.close();
		System.exit(0);

	}
}