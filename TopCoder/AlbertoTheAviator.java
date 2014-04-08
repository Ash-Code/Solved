package TopCoder;

import java.util.TreeSet;

public class AlbertoTheAviator {

	public static int Solve(int F, int[] T, int[] R) {
		int curr = F;
		int p = 0;
		int[] dp = new int[T.length + 1];
		boolean visited[] = new boolean[T.length];
		int max = Integer.MIN_VALUE;
		int count = 0;
		while (max != 0) {
			max = 0;
			boolean found=false;
			for (int i = 0; i < T.length; i++) {
				if(visited[i])
					continue;
				int t = curr - T[i] ;
				if(t>=0)
					t+=R[i];
				else
					continue;
				if (t >= max) {
					max = t;
					p = i;
					found=true;
				}
			}
			if(found){
				
			count++;
			visited[p] = true;
			curr=max;
			System.out.println("Sub "+ T[p]+ " Add "+R[p]+" curr "+ curr + " "+count);
			}
		}

		return count;
	}

	public static void main(String args[]) {
		int[] A = {761, 2614, 1065, 1606, 4192, 4491, 1809, 1104, 2858, 549, 3532, 2299, 3542, 250, 439, 548, 365, 575, 2216, 3435, 3260, 350, 2234, 2872, 3215, 2570, 3881, 2223, 1773, 4253, 3813, 3886, 3218, 4877, 491, 2410, 4368, 3651, 3513};
		int[] B={760, 2613, 917, 1605, 2635, 4303, 1808, 1103, 2857, 548, 2880, 1286, 3541, 249, 438, 390, 364, 574, 2215, 1408, 2494, 349, 1624, 2871, 2648, 479, 625, 1870, 199, 4252, 1343, 4, 3217, 3023, 490, 2409, 3088, 3650, 2764};

		System.out.println(Solve(2862, A, B));

	}
}
