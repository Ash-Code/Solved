package timus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class T1014ProdDig {
	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int t = n;
		boolean found = true;
		int c = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		ytre: while (t > 1 && found) {
			found = false;
			for (int i = 2; i <= 9; i++) {
				if (t % i == 0) {
					found = true;
					list.add(i);
					t /= i;
					break;
				}
			}
		}

		

		for (int i = list.size() - 1; i > 0; i--) {
			int a = list.get(i);
			int b = list.get(i - 1);
			if (a * b < 10) {
				list.set(i - 1, a * b);
				list.remove(i);
			}
		}
		Integer[] res = list.toArray(new Integer[] {});
		Arrays.sort(res);

		if (!found)
			System.out.println(-1);
		else {
			if (n == 1)
				System.out.print(1);
			else if (n == 0)
				System.out.println(10);
			else
				for (int x : res)
					System.out.print(x == 0 ? "" : x);
			System.out.println("");
		}
	}
}
