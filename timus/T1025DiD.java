package timus;

import java.util.Arrays;
import java.util.Scanner;

public class T1025DiD {

	public static void main(String args[]){
		Scanner ss=new Scanner(System.in);
		int n=ss.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=ss.nextInt();
		
	}
		
	int res=0;
	Arrays.sort(arr);
	for(int i=0;i<=n/2;i++){
		res+=(arr[i]/2+1);
	}
	System.out.println(res);
	
	}
	
}
