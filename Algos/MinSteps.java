package CodingPrac;

import java.util.Scanner;

class MinSteps {

	static int n = 0, memo[],dp[], r = 0;

	public static void Read() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number : ");
		n = reader.nextInt();

		memo=dp = new int[n + 1];
		
		for (int i = 0; i < n + 1; i++)
			memo[i] =dp[i]= -1;
		memo[1] = 0;
		System.out.println(DynamicProg(n));
	}

	public static int Memoization(int n) {

		if (memo[n] != -1)
			return memo[n];

		r = 1 + Memoization(n - 1);

		if (n % 2 == 0) {
			r = Math.min(r, 1 + Memoization(n / 2));
		}
		if (n % 3 == 0) {
			r = Math.min(r, 1 + Memoization(n / 3));
		}

		memo[n] = r;
		return r;
	}

	public static int DynamicProg(int n) {
		dp[0]=-1;
		dp[1]=0;
		
		for(int i = 2; i<=n;i++){
			
			dp[i] = 1+ dp[i-1];
			if(i%2==0)
				dp[i]=Math.min(dp[i],1+ dp[i/2]);
			if(i%3==0)
				dp[i]=Math.min(dp[i],1+ dp[i/3]);
					
		}
		for(int i=0;i<=n;i++)
			System.out.println("i "+ i + " dp " + dp[i]);
		
		return dp[n];

		
	}


	

	public static void main(String args[]) {

		MinSteps.Read();

	}

}
