package TopCoder;
public class SlimeXSlimonadeTycoon {

	public int sell(int[] m, int[] c, int s) {
		int res=0;
		int n=m.length;
	
		s--;
		for(int i=0;i<n;i++){
		
			int start=Math.max(i-s,0);
			for(int j=start;j<=i;j++){
				if(m[j]>=c[i]){
					m[j]-=c[i];
					res+=c[i];
					c[j]=0;
				}else{
					c[i]-=m[j];
					res+=m[j];
					m[j]=0;
				}
			}
		}
		
		
		
		
		return res;
	}

}
