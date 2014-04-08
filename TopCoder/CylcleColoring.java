package TopCoder;

import java.util.HashMap;
import java.util.Map;

public class CylcleColoring {
	private static Map<Integer, Long> factorialMap = new HashMap<Integer, Long>();

	public static Long getFactorial(int number) {

		Long val = factorialMap.get(number);
		if (val != null) {

			return val;
		} else {

			val = getFactorialRecursive(number);

			factorialMap.put(number, val);
			return val;
		}
	}

	public static Long getFactorialRecursive(int number) {

		if (number < 2) {
			return 1L;
		} else {
			return number * getFactorial(number - 1);
		}
	}

	public static Long combination(int fromVal, int chooseVal) {
		return getFactorial(fromVal)
				/ (getFactorial(chooseVal) * getFactorial(fromVal - chooseVal));
	}

	public static Long Perm(int fromVal, int chooseVal) {
		return getFactorial(fromVal) / getFactorial(fromVal - chooseVal);
	}

	public static long Solve(int[] V, int[] f, int[] t, int K) {
		boolean ch[] = new boolean[V.length];
		int N = V.length;
		int chains = 0;
		int res = 0;
		chains++;
		for (int i = 0; i <= N; i++) {

			if (f[i % N] == t[(i + 1) % N]) {
				ch[(i + 1)%N] = true;
				continue;
			}
			chains++;
		}
		
System.out.println(Perm(K,chains));

		res += Perm(K, chains) % 1000000007;

		for (int i = 0; i < N; i++) {
			if (ch[(i + 1) % N]) {
				int n = V[(i + 1)%N] - 1;
				if (n > 0)
					res += (long) Math.pow(K - 1, n - 1) * (K - 2) % 1000000007;
			} else {
				int n1 = Math.abs(f[(i + 1) % N] - t[i % N]) - 1;
				int n2 = V[(i + 1)%N] - 2 - n1;
				if (n1 > 0)
					res += (long) Math.pow(K - 1, n1 - 1) * (K - 2)
							% 1000000007;
				if (n2 > 0)
					res += (long) Math.pow(K - 1, n2 - 1) * (K - 2)
							% 1000000007;

			}

		}

		return res;
	}
	
	public static void main(String args[]){
		int[] V={3, 3};
	int[] f=	{0, 0};
	int[] t=	{0, 0};
	System.out.println(Solve(V,f,t,3));
	}

}
