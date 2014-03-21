package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
/*
ID: renegad2
LANG: JAVA
TASK: hamming
*/

public class hamming {

	public static boolean map[][];
	static int N;

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		N = (int) st.nval;
		st.nextToken();
		int B = (int) st.nval;
		st.nextToken();
		int D = (int) st.nval;
		map = new boolean[1 << B][1 << B];
		int count = 0;
		for (int i = 0; i < 1 << B; i++) {
			for (int j = 0; j < 1 << B; j++) {
				count = 0;

				if (!map[i][j]) {
					for (int x = 0; x < B; x++) {
						if (((i >> x & 1) ^ (j >> x & 1)) == 1)
							count++;
					}
					if (count >= D) {
						map[i][j] = true;
						map[j][i] = true;
					}

				}

			}
		}
		boolean ok = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int start = 0;
		while (list.size() < N) {
			list.clear();
			list.add(start);

			for (int i = start + 1; i < 1 << B; i++) {
				int c = i;
				ok = true;
				for (int j = 0; j < list.size(); j++) {
					if (!map[i][list.get(j)]) {
						ok = false;
						break;
					}
				}
				if (ok)
					list.add(c);

			}

			start++;
		}
		int c = 1;
		pw.print(list.get(0));
		for (int i = 1; i < N; i++) {

			if (c == 10) {
				pw.println("");
				pw.print(list.get(i));
				c = 1;
				continue;
			}

			pw.print(" " + list.get(i));
			c++;
		}
		pw.println("");
		pw.close();

		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}

}
