package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
 ID: renegad2
 LANG: JAVA
 TASK: runaround
 */
public class comehome {
	public static PrintWriter pw;
	public static int[][] map;

	public static void floydWarshall() {
		for (int k = 0; k < map.length; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][k] == Integer.MAX_VALUE
							|| map[j][k] == Integer.MAX_VALUE)
						continue;
					if (map[i][k] + map[j][k] < map[i][j]) {
						map[i][j] = map[i][k] + map[j][k];
					}

				}
			}
		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		map = new int[123][123];
		for (int i = 0; i < 123; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}
		for (int i = 0; i < n; i++) {
			st.nextToken();
			int a = st.sval.charAt(0) - 'A';
			st.nextToken();
			int b = st.sval.charAt(0) - 'A';
			st.nextToken();
			int d = (int) st.nval;
			map[a][b] = Math.min(map[a][b], d);
			map[b][a] = map[a][b];
		}
		/*
		 * for (int i = 0; i < 123; i++) { for (int j = 0; j < 123; j++) {
		 * pw.print(map[i][j] == Integer.MAX_VALUE ? -1 : map[i][j] + "    "); }
		 * pw.println(""); } pw.println("");
		 */
		int res = Integer.MAX_VALUE;
		floydWarshall();
char best='A';
		for (int i = 0; i < 25; i++) {
			if (map[i][25] < res){
				res = map[i][25];
				best=(char)(i+65);
				
			}
		}
		pw.println(best+" "+res);
		pw.close();
		System.out.println("Time : " + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
