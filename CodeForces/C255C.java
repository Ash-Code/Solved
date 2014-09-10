package CodeForces;

import java.util.Scanner;

public class C255C {

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int n = ss.nextInt();
		int[] in = new int[n];
		for (int i = 0; i < n; i++) {
			in[i] = ss.nextInt();
		}

		int max = 0;
		int temp = 0;
		int last = -1;
		for (int i = 0; i < n; i++) {
		//	System.out.println(in[i]+ " "+temp);
			if (in[i] > last) {
				last = in[i];
				temp++;
			} else {
				if (i < n - 1 && in[i + 1] > last + 1) {
					temp += 2;
					
					last = in[i + 1];
					i+=1;
				} else {
					temp = 1;
					last = in[i];
				}
			}

			if (temp > max)
				max = temp;

		//	System.out.println(in[i]+" "+temp+" "+i+" "+last);
			
		}
		
		System.out.println(max);

	}

}
