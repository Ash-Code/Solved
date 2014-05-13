package TopCoder;
public class MagicDiamonds {

	public long minimalTransfer(long n) {
		long lim=(long)Math.sqrt(n)+1;
		boolean flag=false;
		for(long i=2;i<lim;i++){
			if(n%i==0){
				flag=true;
				break;
			}
		}
		if(n==1)
			return 1;
		if(n==3)
			return 3;
		
		return flag?1:2;
	}

}
