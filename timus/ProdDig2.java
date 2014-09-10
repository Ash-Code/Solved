package timus;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProdDig2 {
	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		long n = ss.nextLong();
		if (n == 1) {
			System.out.println(1);
			return;
		}
		if(n==0){
			System.out.println(10);
			return;
		}
			
		LinkedList<Integer> list = new LinkedList<Integer>();
		boolean found = true;
		while (found&&n!=1) {
			found = false;
			for (int i = 9; i >= 2; i--) {
				if (n % i == 0) {
					n /= i;
					found = true;
					list.add(i);
					break;
				}
			}
		}
		Collections.sort(list);
		long ans = 0;
		for (int x : list) {
			ans *= 10;
			ans += (long) x;
		}

		System.out.println(n != 1 ? -1 : ans);
		return;

	}
}
