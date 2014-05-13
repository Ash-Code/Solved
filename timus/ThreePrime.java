package timus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ThreePrime {

	public static void main(String args[]) {
		int count = 0, mod = 1000000009;
		HashSet<Integer> set = new HashSet<Integer>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] start = new int[100];
		int[] end = new int[100];

		ytre: for (int i = 100; i <= 999; i++) {
			int lim = (int) Math.sqrt(i) + 1;
			for (int j = 2; j <= lim; j++) {
				if (i % j == 0) {
					continue ytre;
				}

			}
			start[i / 10]++;
			end[i % 100]++;
		}
		
		for(int i=4;i<=n;i++){
			for(int k=0;k<100;k++){
				if(end[k]==0)
					continue;
				
			}
		}
		

		System.out.println(" ");
		System.out.println((count * 19));

	}

}
