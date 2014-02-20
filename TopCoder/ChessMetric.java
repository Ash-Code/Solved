package CodeProbs;

import java.util.LinkedList;

public class ChessMetric {// this approach leads to outofMemoryError. So BFS is
							// not applicable. Must use Dynamic programming

	public static class Node {
		int x, y;
		int moves;
		boolean[][] visited;

		public Node(int x, int y, int moves, boolean[][] vis) {
			this.x = x;
			this.y = y;

			this.moves = moves;
			this.visited = vis;
			this.visited[x][y] = true;
		}
	}

	public static long howMany(int size, int[] start, int[] end, int numMoves) {
		int limit = size - 1, endx = end[0], endy = end[1], ways = 0;
		boolean v[][] = new boolean[size][size];

		v[start[0]][start[1]] = false;
		Node st = new Node(start[0], start[1], 0, v);
		st.visited[start[0]][start[1]] = false;
		Node temp, top;
		int count = 0;
		int finalx = 0, finaly = 0;
		LinkedList<Node> s = new LinkedList<Node>();
		s.add(st);
		while (!s.isEmpty()) {

			top = s.removeFirst();

			if (top.x == endx && top.y == endy && top.moves == numMoves)
				ways++;

			for (int i = -1; i <= 1; i += 1) {
				for (int j = -1; j <= 1; j += 1) {

					finalx = top.x + i;
					finaly = top.y + j;
					if (!(finalx > limit || finaly > limit || finalx < 0 || finaly < 0)) {
						if (!top.visited[finalx][finaly]
								&& (!(i == 0 && j == 0))) {
							boolean[][] tem = new boolean[size][size];
							for (int a = 0; a < size; a++) {
								for (int b = 0; b < size; b++) {
									tem[a][b] = top.visited[a][b];

								}

							}

							temp = new Node(finalx, finaly, top.moves + 1, tem);

							s.add(temp);

						}
					}

				}
			}

			for (int l = -2; l <= 2; l += 4) {
				for (int e = -1; e <= 1; e += 2) {
					finalx = top.x + l;
					finaly = top.y + e;
					if (!(finalx > limit || finaly > limit || finalx < 0 || finaly < 0)) {
						if (!top.visited[finalx][finaly]) {
							boolean[][] tem = new boolean[size][size];
							for (int a = 0; a < size; a++) {
								for (int b = 0; b < size; b++) {
									tem[a][b] = top.visited[a][b];

								}

							}

							s.add(new Node(finalx, finaly, top.moves + 1, tem));
							s.add(new Node(finaly, finalx, top.moves + 1, tem));
						}
					}
				}
			}

		}

		return ways;

	}

	public static void main(String args[]) {
		int size = 10;
		int[] start = { 5, 5 };
		int[] end = { 9, 9 };
		int numMoves = 4;

		System.out.println(howMany(size, start, end, numMoves));
	}

}
