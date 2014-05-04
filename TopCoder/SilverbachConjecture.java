package TopCoder;
public class SilverbachConjecture {

	public boolean check(int x){
		int lim=(int)Math.sqrt(x)+1;
		
		for(int i=2;i<lim;i++){
			if(x%i==0)
				return true;
		}
		return false;
	}
	
	public int[] solve(int n) {
		int[] res=new int[2];	
		for(int i=4;i<n-3;i++){
			int n2=n-i;
			if(check(i)&&check(n2)){
				res[0]=i;
				res[1]=n2;
				break;
			}
		}
		
		return res;
	}

}
