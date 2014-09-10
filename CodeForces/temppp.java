package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class temppp {
	static BufferedReader bf;
	static PrintWriter pw;

	public static boolean isWhite(int x, int y) {
		if ((x + y) % 2 == 0)
			return false;

		return true;
	}

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		StreamTokenizer st = new StreamTokenizer(bf);
		Scanner ss = new Scanner(System.in);
		st.nextToken();
		int n = (int) st.nval;

		long[][] map = new long[n][n];
		long[] left = new long[2 * n];
		long[] right = new long[2 * n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				st.nextToken();
				map[i][j] = (long) st.nval;
			}
		}
		for (int i = 0; i < n; i++) {
			int pos = i - 0;
			left[n - 1 + pos] = 0;
			int x = i;
			int y = 0;
			while (x < n && y < n) {
				left[n - 1 + pos] += (long) map[x][y];
				x++;
				y++;
			}
		}
		for (int j = 1; j < n; j++) {
			int pos = 0 - j;
			left[n - 1 + pos] = 0;
			int x = 0;
			int y = j;
			while (x < n && y < n) {
				left[n - 1 + pos] += (long) map[x][y];
				x++;
				y++;
			}
		}
		for (int j = 0; j < n; j++) {
			right[j] = 0;
			int x = 0;
			int y = j;
			while (x < n && y >= 0) {
				right[j] += map[x][y];
				x++;
				y--;
			}

		}

		for (int i = 1; i < n; i++) {
			int y = n - 1;
			int x = i;
			int pos = x + y;
			while (x < n && y >= 0) {
				right[pos] += map[x][y];
				x++;
				y--;
			}
		}
	

		long maxBlack = 0;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		long maxWhite = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long res = left[n - 1 + i - j];
				res += right[i + j];
				res -= map[i][j];
				if (isWhite(i, j)) {
					if (res >= maxWhite) {
						maxWhite = res;
						x1 = i + 1;
						y1 = j + 1;
					}
				} else {
					if (res >= maxBlack) {
						maxBlack = res;
						x2 = i + 1;
						y2 = j + 1;
					}
				}
			}
		}
		pw.println(maxBlack + maxWhite);
		pw.println(x1 + " " + y1 + " " + x2 + " " + y2);
		bf.close();
		pw.close();

	}
}
