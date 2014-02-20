package CodeProbs;

import java.util.ArrayList;
import java.util.Collections;

public class FlowerGarder {
	
	
	
	
	public static int getOrdering2(int height[], int bloom[], int wilt[]){
		ArrayList<Integer> order, heights = new ArrayList<Integer>();
		
		for(int i=0;i<height.length;i++){
			heights.add(height[i]);
		}
		order=(ArrayList<Integer>)heights.clone();
		Collections.sort(order);
		Collections.reverse(order);
	
				
		for(int i=0;i<order.size();i++){
			System.out.println(order.get(i));
		}
		
		
		
		int x,y= 0;
		
		for(int i=1;i<height.length;i++){
			for(int j=0;j<i;j++){
				
				x =heights.indexOf(order.get(i));
				y = heights.indexOf(order.get(j));
				
				
				
				
				
				}
				
			}
		
		
		
		return 0 ;
	}
	public static int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
		long startTime = 0;
		
		int n = height.length;
		int[] svar = new int[n];
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; ++i) {
			int best = -1;
			int verdi = -1;
			ytre: for (int j = 0; j < n; ++j) {
				if (used[j])
					continue;//<-------jumps to next j
				if (height[j] <= verdi)
					continue;//<-------jumps to next j
				for (int k = 0; k < n; ++k) {
					if (used[k])
						continue;
					if (height[k] >= height[j])
						continue;
					if (bloom[k] <= wilt[j] && wilt[k] >= bloom[j])// i.e. blocking//
						continue ytre;//<-------jumps to next j
				}
				best = j;
				System.out.println("best and verdi recorded for j= " + j);
				verdi = height[j];
				
			}
			used[best] = true;
			svar[i] = height[best];
			System.out.println("for i = " + i + "the best value = " + best + " height of best : " + height[best]);
			
		}

		
		return svar;
	}
	
	
	
	public static boolean blocker(int bloomi, int bloomj, int wilti, int wiltj){
		if(bloomi>wiltj&&wilti<bloomj){
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String args[]){
	int[] height ={3,2,5,4};
	int[] bloom={1,2,11,10};
	int[] wilt ={4,3,12,13};
int result[] = new int[4];
		result = getOrdering(height,bloom,wilt);

		
	}
	
}
