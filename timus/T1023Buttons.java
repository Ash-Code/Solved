package timus;

import java.util.Scanner;

public class T1023Buttons {
	public static int[][] dp;
	
	

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		int k = ss.nextInt();
		
		for(int i=2;i<k;i++){
			int extra=k%i;
			if(extra==1){
				System.out.println(i);
				return;
			}
				
		}

		ss.close();
		
	
	}
}
