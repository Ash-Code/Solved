package TopCoder;

public class TheMatrix {

	public static int Solve(int[][] map) {
		int[][] mark = new int[map.length][map[0].length];
		int[][] mar = new int[map.length][map[0].length];
		int height = map.length;
		int width = map[0].length;

		for (int i = 0; i < height; i++) {
			mark[i][0] = 1;
			for (int j = 1; j < width; j++) {
				if (map[i][j] != map[i][j - 1]) {
					mark[i][j] = mark[i][j - 1] + 1;
				} else
					mark[i][j] = 1;
			}
		}
		System.out.println("");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(mark[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		int max = 1;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int best = mark[i][j];
				int count = 1, k = i + 1;
				max = Math.max(mark[i][j], max);
				while (k < height && map[k][j] != map[k - 1][j]) {
					count++;
					// the most headache i ever had. Remember, compare every
					// result with max to get the result. Including the starting
					// case where there is jjust one row. The placement of
					// count++, K++ etc matters ALOT. Fuckin use your head once
					// in a while
					best = Math.min(best, mark[k][j]);
					max = Math.max(max, best * count);
					k++;
				}

			}
		}

		return max;
	}

	public static void main(String args[]) {

		String[] S = { "10101", "01000", "10100", "01010", "10101", "00010",
				"10101", "01010", "10101", "01000", "10101", "01010", "10101",
				"01011", "10101", "01010", "10101", "01010", "10101", "00010",
				"10101" };
		int[][] map = new int[S.length][S[0].length()];

		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S[0].length(); j++) {
				map[i][j] = S[i].charAt(j) - '0';
			}
		}

		System.out.println(Solve(map));
	}

}
