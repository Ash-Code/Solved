package TopCoder;
import java.util.Arrays;

public class BubbleSortWithReversals {

	public static int getCount(int start, int end,int[] A) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			for (int j = 0; j < i; j++)
				if (A[j] > A[i])
					count++;
		}

		return count;
	}

	public static void reverse(int[] A, int start, int end) {
		int t = 0;
		for (int i = start, j = end; i < j; i++, j--) {
			t = A[i];
			A[i] = A[j];
			A[j] = t;
		}
		
	}

	public static int getMinSwaps(int[] A, int K) {

		int[][] dp = new int[A.length + 1][K + 1];
		for (int i = A.length - 1; i >= 0; i--) {
			for (int k = 0; k <= K; k++) {
				dp[i][k] = getCount(i,i, A) + dp[i + 1][k];

				if (k >= 1) {

					for (int y = i + 1; y < A.length; y++) {
						int[] B = Arrays.copyOf(A, A.length);
						reverse(B, i, y);
						dp[i][k] = Math.min(dp[i][k],
								(getCount(i, y, B) + dp[y + 1][k - 1]));

						/*System.out.println("   k>=1 "
								+ getCount(i,y, B) + " for i & y " + i
								+ "," + y + " and ahead " + dp[y + 1][k - 1]);*/

					}
				}

				System.out.println(i + " k : " + k + " " + dp[i][k]);

			}
		}

		return dp[0][K];
	}

	/*public static void main(String args[]) {
		int[] x = { 482, 619, 619, 601, 660, 660, 691, 691, 77, 77, 96, 77 };
		System.out.println(getMinSwaps(x, 9));

	}*/
}
