package CodeProbs;

import java.util.Scanner;

public class Kbased {

	public static int nums(int k, int n) {

		int[] m = new int[n + 1];
		// Dynamic
		m[1] = k - 1;
		m[2] = k * (k - 1);
		for (int i = 3; i <= n; i++) {
			m[i] = (m[i - 1] + m[i - 2]) * (k - 1);
		}
		return (m[n]);

	}

	public static void main(String args[]) {

		System.out.println(nums(2, 10));

	}

}
