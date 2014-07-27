package timus;

import java.util.Scanner;

public class T1020Rope {
	public static double distPoints(double[] A, double[] B) {

		return Math.sqrt(((A[0] - B[0]) * (A[0] - B[0]))
				+ ((A[1] - B[1]) * (A[1] - B[1])));
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		double R = ss.nextDouble();
		double res = 0;
		res += (2 * Math.PI * R);
		double[][] coords = new double[n][2];
		for (int i = 0; i < n; i++) {
			double x = ss.nextDouble();
			double y = ss.nextDouble();
			coords[i][0] = x;
			coords[i][1] = y;
		}
		for (int i = 1; i < n; i++) {
			res += distPoints(coords[i], coords[i - 1]);
		}
		if (n > 1) {
			res += distPoints(coords[n - 1], coords[0]);
		}

		System.out.println(String.format("%.2f", res));
	}

}
