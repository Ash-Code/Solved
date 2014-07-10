package TopCoder;
import java.util.Arrays;

public class IncrementingSequence {

	public String canItBeDone(int k, int[] A) {
		int n = A.length;
		boolean res = true;
		Arrays.sort(A);
		if (A[n - 1] > n) {
			res = false;
		}
		int[] t = new int[n + 1];
		if (res) {
			for (int i = 0; i < n; i++) {
				t[A[i]]++;
			}

			for (int i = n; i >= 1; i--) {
				if (t[i] == 0) {
					for (int j = i; j >= 0; j--) {
						if (t[j] > 1) {
							if ((i - j) % k == 0) {
								t[j]--;
								t[i]++;
								break;
							}
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				System.out.println(t[i]);
				if (t[i] == 0)
					res = false;
			}

		}
		

		return res ? "POSSIBLE" : "IMPOSSIBLE";
	}

}
