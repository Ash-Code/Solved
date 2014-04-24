package TopCoder;
//
public class TrafficCongestionDiv2 {

	public static long Solve(int n){
	long dp[]=new long[n+1];
	dp[0]=1;
	dp[1]=1;
	
	for(int i=2;i<n+1;i++){
		for(int j=0;j<=i-2;j++){
			dp[i]+=2*dp[j];
		}
		dp[i]+=1;
		
	}
	return dp[n];
		
	}
	
	public static void main(String args[]){
		System.out.println(Solve(3));
	}
	
}
