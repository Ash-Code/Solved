package timus;

import java.util.Arrays;
import java.util.Scanner;

public class T1021Sacrament {

	public static boolean binarySearch(int x, int[] A) {
		int start = 0;
		int end = A.length - 1;
		//System.out.println("Target " + x+" " +start+" "+end);
		while (end-start > 1) {
			int mid = start + (end - start) / 2;
			//System.out.println("   " + start + " " + end + " val " + A[mid]);
			if (A[mid] == x)
				return true;
			else if (A[mid] > x)
				end = mid;
			else
				start = mid;
		}

		if (A[start] == x || A[end] == x)
			return true;

		return false;
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = ss.nextInt();

		int m = ss.nextInt();
		int[] B = new int[m];
		for (int i = 0; i < m; i++)
			B[i] = ss.nextInt();
		boolean found = false;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < n; i++) {
			int search = 10000 - A[i];
			if (binarySearch(search, B)) {
				found = true;
				break;
			}
		}

		System.out.println(found == true ? "YES" : "NO");

	}

}
