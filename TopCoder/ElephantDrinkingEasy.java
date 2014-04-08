package TopCoder;

public class ElephantDrinkingEasy {
	public static int Solve(String[] map) {
		int n=map.length;
		
		boolean L[]=new boolean[n];
		boolean T[]=new boolean[n];
		boolean R[]=new boolean[n];
		boolean B[]=new boolean[n];
		int d=-1;
		for(int i=n;i>0;i-=2){
	d++;
			for(int j=d;j<n-d;j++){
				System.out.print(map[d].charAt(j)+""+map[n-1-d].charAt(j)+""+map[j].charAt(d)+""+map[j].charAt(n-1-d)+"   ");
				
				if(map[d].charAt(j)=='Y'){
				
					T[j]=true;
				}
				if(map[n-1-d].charAt(j)=='Y'){
					B[j]=true;
				}
				
				if(map[j].charAt(d)=='Y'&& (j!=d)&&(j!=n-1-d)){
					
					if(L[j] && map[j].charAt(n-1-d)=='N')
						R[j]=true;
					else
						L[j]=true;
						
				}
				
				if(map[j].charAt(n-1-d)=='Y'&& (j!=d)&&(j!=n-1-d)){
					if(R[j] && map[j].charAt(d)=='N')
						L[j]=true;
					else
						R[j]=true;
						
				}
				
					
			}
			
			System.out.println("          d "+d);
			
		}
		
		int res=0;
		for(int i=0;i<n;i++){
			if(L[i])
				res++;
			if(T[i])
				res++;
			if(R[i])
				res++;
			if(B[i])
				res++;
			
		}
		return res;
	}
	
	public static void main(String args[]){
	String[] map=  {"NNNNN",
			 "NNYYN",
			 "NYNNN",
			 "NNYNN",
			 "NNNNN"}
;
		System.out.println(Solve(map));
	}

}
