package CodeProbs;

public class Mortage {

	public static int MonthlyPayment(int loan, int interest, int term ){
		double inter=(double)interest, l=(double)loan;
		
		inter/=10;
		double rate=inter/1200;
		
		 int min=0, max= loan, mid=(min+max)/2;
		int months=term*12;
long bal=loan;
		long diff=Long.MIN_VALUE; int val=0;
		System.out.println(Integer.MIN_VALUE);
		
		while(min+1<max){
			mid=min+(max-min)/2;
		
			bal=loan;
			for(int i=0;i<months;i++){
				bal=(int)Math.ceil((bal-mid)*(1+ rate));
				if(bal<0){
					i=months;
				}
			}
			
			if(bal<0){
				if(diff<bal){
					diff=bal;
					val=(int)mid;	
				}
				max=mid;
			}else{
				min=mid;
			}
			
		
		}

		bal=loan;
		for(int i=0;i<months;i++){
			bal=(long)Math.ceil((bal-max+1)*(1+ rate));
			if(bal<0)
				i=months;
		}
		System.out.println(rate);
		
		return val;
		
	}

	public static void main(String args[]) {
		System.out.println(MonthlyPayment(1000000,
				1000000,
				1000));
	}

}
