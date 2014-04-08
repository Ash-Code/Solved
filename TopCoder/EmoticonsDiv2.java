package TopCoder;

public class EmoticonsDiv2 {
	public static long dp[] = new long[1001];

	public static long Solve(int S) {

		if (S == 1) {
			return 0;
		}
		
		if (dp[S] != 0)
			return dp[S];

		long min = Long.MAX_VALUE;
		for (int i = 1; i <= (S / 2); i++) {

			if (S % i == 0) {
				long t = Solve(i) + S / i;
				if (t < min) {
					min = t;
				}
			}

		}

		dp[S]=min;
		
		return dp[S];
	}
	
	 static public int printSmiles(int smiles) { 
		    int actions=2,len=2,copy=1; 
		    smiles-=2; 
		    while(smiles>0) { 
		      if(smiles%len==0) 
		      { 
		        copy=len; 
		        smiles-=copy; 
		        len+=copy; 
		        actions+=2; 
		      } else 
		      { 
		        smiles-=copy; 
		        len+=copy; 
		        actions++; 
		      } 
		      System.out.println(smiles); 
		    } 
		    return actions; 
		  } 

	public static void main(String args[]){
		System.out.println(printSmiles(6));
		
	}
}
