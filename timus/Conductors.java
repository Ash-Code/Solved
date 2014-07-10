package timus;

import java.util.Scanner;

public class Conductors {

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		double P = ss.nextDouble();
		P /= 100;
		double Q = ss.nextDouble();
		Q /= 100;
		int res = 0;
		//System.out.println(P + " " + Q);
		for (int i = 1;; i++) {

			double lower = P * i;
			double upper = Q * i;
			double iu = (int) upper;
			double il = 0;
			if (lower - (int) lower > 1e-7)
				il = (int) lower + 1;
			else
				il = (int) lower;

		//	System.out.println(" i : " + i + " " + "lower : " + lower
			//		+ " upper : " + upper + " " + iu + " " + il);

			if (il <= iu) {
				
				if ((Q-(iu / i)>1e-9) && ((il / i) -P>1e-9)) {
					res = i;
					break;
				}
			
			}

		}
		System.out.println(res);

	}

}
