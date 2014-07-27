package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 ID: renegad2
 LANG: JAVA
 TASK: cowtour
 */
public class cowtour {
	public static PrintWriter pw;
	public static double[][] map;
	public static int[][] loc;
	public static int[] component;
	public static double[][] bestD;
	public static double[] lDis;

	public static double getDis(int x1, int y1, int x2, int y2) {
		return Math.sqrt((double) (x1 - x2) * (x1 - x2) + (double) (y1 - y2)
				* (y1 - y2));

	}

	public static void bfsScan(int comp) {
		int nfound = 0;
		do{
			nfound = 0;
			for (int i = 0; i < component.length; i++) {
				if (component[i] == -2) {
					nfound++;
					component[i] = comp;
					for (int j = 0; j < component.length; j++) {
						if (map[i][j] > 0 && component[j] == 0) {

							component[j] = -2;
						}
					}

				}
			}
		}while(nfound!=0);
	}

	public static void floydWarshall(int comp) {

		for (int k = 0; k < loc.length; k++) {
			if (component[k] != comp)
				continue;
			for (int j = 0; j < loc.length; j++) {
				if (component[j] != comp)
					continue;
				for (int i = 0; i < loc.length; i++) {
					

					if (component[i] != comp)
						continue;

					if (bestD[i][k] + bestD[k][j] < bestD[i][j]) {

						bestD[i][j] = bestD[i][k] + bestD[k][j];
					}

				}
			}
		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		int N = Integer.parseInt(bf.readLine());
		map = new double[N][N];
		loc = new int[N][2];
		component = new int[N];
		bestD = new double[N][N];
		lDis = new double[loc.length];
		Scanner ss;
		for (int i = 0; i < N; i++) {
			ss = new Scanner(bf.readLine());
			loc[i][0] = ss.nextInt();
			loc[i][1] = ss.nextInt();
		}
		for (int i = 0; i < N; i++) {
			char[] in = bf.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (in[j] == '1') {

					map[i][j] = getDis(loc[i][0], loc[i][1], loc[j][0],
							loc[j][1]);
					bestD[i][j] = map[i][j];

				} else {
					if (i == j)
						bestD[i][j] = 0;
					else
						bestD[i][j] = Double.MAX_VALUE;
				}
			}
		}
		int comp = 0;
		for (int i = 0; i < N; i++) {
			if (component[i] == 0) {
				comp++;
				component[i] = -2;
				bfsScan(comp);
			}
		}

		int[] temp = Arrays.copyOf(component, component.length);
		Arrays.sort(temp);
		int last = 0;
		for (int i = 0; i < N; i++) {
			if (temp[i] != last) {
				//System.out.println(temp[i]);
				floydWarshall(temp[i]);
				last = temp[i];
			}
		}

		// for (int i = 0; i < N; i++) {
		// System.out.print(temp[i] + " ");
		// }

		// System.out.println("");

		for (int i = 0; i < N; i++) {
			double largest = 0;
			for (int j = 0; j < N; j++) {
				if (bestD[i][j] > largest && bestD[i][j] != Double.MAX_VALUE)
					largest = bestD[i][j];
			}
			lDis[i] = largest;

		}
		

		double LSP = Double.MAX_VALUE;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (i == j||component[i]==component[j])
					continue;
				if (bestD[i][j] == Double.MAX_VALUE) {
					double t = lDis[i]
							+ lDis[j]
							+ getDis(loc[i][0], loc[i][1], loc[j][0], loc[j][1]);
					if (t <= LSP)
						LSP = t;
				}

			}

		}
		double res=0;
		for(int i=0;i<N;i++){
			res=Math.max(res, lDis[i]);
		}

		
		pw.println(String.format("%.6f", Math.max(LSP, res)));

		bf.close();
		pw.close();
		System.out.println(" Time : " + (System.currentTimeMillis() - time));
		System.exit(0);
	}
}
