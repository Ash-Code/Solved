package Algos;

public class gcd {
	
	
	public static long gcdd(long a, long b) {		
		
		
		if (a % b == 0)
			return b;

		return gcdd(a, a % b);

	}
	
	public static void main(String args[]){
	System.out.println(	gcdd(767622,788));
	}

}
