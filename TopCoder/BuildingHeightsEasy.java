package TopCoder;
import java.util.Arrays;

public class BuildingHeightsEasy {

	public int minimum(int M, int[] heights) {
		Arrays.sort(heights);
		int min=Integer.MAX_VALUE;
		for(int j=M-1;j<heights.length;j++){
			int sum=0;
			int target=heights[j];
		int start=j-M+1;
		for(int i=start;i<=j;i++){
			sum+=(target-heights[i]);
		}
		min=Math.min(min, sum);
		}
		return min;
		
	}

}
