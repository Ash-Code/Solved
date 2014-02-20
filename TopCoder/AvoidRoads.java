package CodeProbs;

import java.util.LinkedList;

public class AvoidRoads {

	public static long numWays(int width, int height, String[] bad) {
		int[][] grid = new int[height + 1][width + 1];
		LinkedList<int[]> badint = new LinkedList<int[]>();
		badint.clear();
		
		int pair1[] = new int[2], pair2[] = new int[2];

		String[] split;
int x=0;
		for (int i = 0; i < bad.length; i++) {// the bloody fuck is wrong 
			split = bad[i].split(" ");
			pair1[0] = Integer.parseInt(split[0]);
			pair1[1] = Integer.parseInt(split[1]);
			pair2[0] = Integer.parseInt(split[2]);
			pair2[1] = Integer.parseInt(split[3]);
			System.out.println("pair " + pair1[0] + " " + pair1[1]);
			System.out.println("pair " + pair2[0] + " " + pair2[1]);
			System.out.println(badint.add(pair1));
			System.out.println(" added : "+ x+ " vals : " +badint.get(x)[0]+" "+ badint.get(x)[1]);
			System.out.println(badint.add(pair2));
			System.out.println(" added : "+ (x+1) + " vals : " +badint.get(x+1)[0]+" "+ badint.get(x+1)[1]);
			x+=2;
		}
		
		grid[0][0] = 1;
		int dj[] = { 1, 0 };
		int di[] = { 0, 1 };
		
		
		for (int i = 0; i < badint.size(); i++){
			pair1 = badint.get(i);
			System.out.println(i+" " + pair1[0] + " " +pair1[1]);
		}
		
		int fj, fi;
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= width; j++) {
				for (int k = 0; k < 2; k++) {
					fi = i + di[k];
					fj = j + dj[k];

					pair1[0] = i;
					pair1[1] = j;
					pair2[0] = fi;
					pair2[1] = fj;
					

					if (!(badint.contains(pair1) && badint.contains(pair2))) {
						grid[fi][fj] += grid[i][j];
					}
				}

			}
		}
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= width; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}
		return grid[height][width];

	}

	public static void main(String args[]) {
		int width = 6;
		int height = 6;
		String[] bad = { "0 0 0 1", "6 6 5 6" };
		System.out.println(numWays(width, height, bad));
	}
}
