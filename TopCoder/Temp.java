package TopCoder;

public class Temp {

	public static String Solve(String S, String A, String B) {
		if (S.length() != (A.length() + B.length())) {
			return "";

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char x=S.charAt(i);
			if (S.charAt(i) == '?') {
				
				
			}else{
				int a=0,b=0;
				while(A.charAt(a)==x&&B.charAt(b)==x){
					sb.append(x);
					
					
				}
				
				
				
			}
		
			
			
			

		}

		return "";

	}

	public static void main(String args[]) {
		long x = 1000010000100001L;
		System.out.println();

	}
}
