package CodeProbs;

import java.util.LinkedList;

import CodeProbs.ChessMetric.Node;

public class ChessMetric2 {
	static int stx, sty;

	public static long howMany(int size, int[] start, int[] end, int numMoves) {

		long[][] ways = new long[size][size], temp = new long[size][size];
		int finalx = 0, finaly = 0;
		stx = start[0];
		sty = start[1];

		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				ways[i][j] = 0;
		ways[stx][sty] = 1;

		for (int k = 0; k < numMoves; k++) {
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					temp[i][j]=ways[i][j];
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					ways[i][j] = 0;
			
			for (int a = 0; a < size; a++) {
				for (int b = 0; b < size; b++) {

					for (int i = -1; i <= 1; i += 1) {
						for (int j = -1; j <= 1; j += 1) {
							finalx = a + i;
							finaly = b + j;
							if ((finalx >= 0 && finaly >= 0 && finalx < size && finaly < size)
									&& (!(i == 0 && j == 0)))
								ways[finalx][finaly] += temp[a][b];
						}
					}

					for (int l = -2; l <= 2; l += 4) {
						for (int e = -1; e <= 1; e += 2) {
							finalx = a + l;
							finaly = b + e;
							if (finalx >= 0 && finaly >= 0 && finalx < size
									&& finaly < size) {
								ways[finalx][finaly] += temp[a][b];
								ways[finaly][finalx] += temp[a][b];
							}
						}
					}
				}
				
				
			}
			
		}
		return ways[end[0]][end[1]];

	}

	public static void main(String args[]) {
		int size = 100;
		int[] start = { 0, 0 };
		int[] end = { 0, 99 };
		int numMoves = 50;

		System.out.println(howMany(size, start, end, numMoves));
	}

}
