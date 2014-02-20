package CodeProbs;

public class ColorfulRoads {
	public static int Solve(String road) {
		int[] cost = new int[road.length()];
		int[] r = new int[road.length()];
		for (int i = 0; i < road.length(); i++)
			cost[i] = 1000000000;
		for (int i = 0; i < road.length(); i++) {
			if (road.substring(i, i + 1).equals("R"))
				r[i] = 0;

			if (road.substring(i, i + 1).equals("G"))
				r[i] = 1;

			if (road.substring(i, i + 1).equals("B"))
				r[i] = 2;

		}
		int temp = 0;
		cost[0] = 0;
		for (int i = 0; i < road.length(); i++) {
			for (int j = 0; j < i; j++) {
				if ((r[j] == r[i] - 1) || (r[j] == 2 && r[i] == 0)) {

					temp = cost[j] + (int) Math.pow(j - i, 2);
					if (cost[i] > temp)
						cost[i] = temp;

				}
			}
		}
		if (cost[road.length() - 1] == 1000000000)
			return -1;

		return cost[road.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(Solve("RGBRGBRGB"));
	}

}