package timus;

import java.util.Arrays;
import java.util.Scanner;

public class T1026QnA {

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = ss.nextInt();

		Arrays.sort(arr);
		ss.next();
		int m = ss.nextInt();
		for (int i = 0; i < m; i++)
			System.out.println(arr[ss.nextInt()-1]);

	}

}
