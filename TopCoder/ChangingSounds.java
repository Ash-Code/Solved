package CodeProbs;

public class ChangingSounds {

	public static int SolveDP(int[] A, int begin, int maxLevel) {
		int limit[] = new int[A.length + 1];
		limit[A.length] = maxLevel;

		int B[] = new int[A.length + 1];
		B[0] = 0;
		for (int i = 1; i <= A.length; i++) {
			B[i] = A[i - 1];
		}
		for (int i = A.length - 1; i > 0; i--) {
			int sub = limit[i + 1] - B[i + 1];
			int add = limit[i + 1] + B[i + 1];

			if (sub >= 0 && sub <= maxLevel) {
				limit[i] = sub;
				if (add >= 0 && add <= maxLevel) {
					limit[i] = (int) Math.min(sub, add);
				}
			}else if(add>=0&&add<=maxLevel){
				limit[i]=add;
			}

		}

		int dp[] = new int[A.length + 1];
		for (int i = 0; i < B.length; i++)
			dp[i] = Integer.MAX_VALUE;
		dp[0] = begin;

		for (int i = 1; i <= A.length; i++) {
			int temp = dp[i - 1] + B[i];
			if (temp >= 0 && temp <= limit[i]) {

				dp[i] = temp;
			} else if (dp[i - 1] - B[i] >= 0 && dp[i - 1] - B[i] <= limit[i]) {
				dp[i] = dp[i - 1] - B[i];
			}

			System.out.println("i :" + i + " dp " + dp[i] + " prev "
					+ dp[i - 1] + " manip " + B[i] + " limit " + limit[i]);

		}
		return dp[A.length];

	}

	public static int Solve(int[] A, int begin, int maxLevel) {
		int start = (int) Math.pow(2, (A.length));

		int end = (int) (Math.pow(2, (A.length + 1)) - 1);
		System.out.println(A.length);

		int total = begin, max = -1;
		for (int i = start; i <= end; i++) {
			total = begin;
			for (int j = 0; j < A.length; j++) {
				if (total <= maxLevel && total >= 0) {
					if ((i & 1 << j) == 1 << j) {

						total += A[j];
					}
					if ((i & (1 << j)) == 0) {

						total -= A[j];
					}
				}
			}

			if (total > max && total <= maxLevel)
				max = total;
		}

		return max;

	}

	public static void main(String args[]) {
		int[] A = { 74, 39, 127, 95, 63, 140, 99, 96, 154, 18, 137, 162, 14, 88 };

		System.out.println(SolveDP(A, 40, 243));

	}
}
