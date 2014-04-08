package TopCoder;

import java.util.Arrays;

public class TaroFriendsDiv2 {


		public static int getNumber(int[] c, int X) {
			Arrays.sort(c);
		int res=c[c.length-1]-c[0];
			for(int i=0;i<c.length-1;i++){
				int left=Math.min(c[0]+X, c[i+1]-X);
				int right=Math.max(c[c.length-1]-X, c[i]+X);
				res=Math.min(res, right-left);
			}
			return res;
			
			
			
			
		}

		public static void main(String args[]) {
		
			int[] a={106, 347, -103, -482, 807, -507, -485, -582};
			System.out.println(getNumber(a, 832));
		}
	}