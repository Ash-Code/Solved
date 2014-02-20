package CodeProbs;

public class LittleElephantPerms {

	public static long Solve(int N, int K){
		long fac=1;
		for(int i=N;i>0;i--)
			fac*=i;
		long dec=N, temp=N-1, sub ;
		long perms=fac*fac;
		int sum=(N*(N+1))/2;
		System.out.println("fac "+ fac+" sum "+sum);
		System.out.println(perms);
		
		
		for(int i=sum;i<K;i++){
		
		if(dec==0){
			temp--;
			dec=temp;
		}
			dec--;
			sub=(fac*dec);
				perms-=sub;
		
	
		}
	
		
		
		return perms;
	}
	
	public static void main(String args[]){
		System.out.println(Solve(4,50));
		
	}
	
	
			
}
