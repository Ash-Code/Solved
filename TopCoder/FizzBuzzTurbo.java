package TopCoder;
public class FizzBuzzTurbo {

	public long[] Solve(long A) {
		long[] res = new long[3];
		if (A == 0)
			return res;
		long fizz = A / 3;
		long buzz = A / 5;
		long fb = A / 15;
		res[0] = fizz - fb;
		res[1] = buzz - fb;
		res[2] = fb;

		return res;

	}

	public long[] counts(long A, long B) {
		long[] x1 = Solve(A - 1);
		long[] x2 = Solve(B);
		for (int i = 0; i < 3; i++)
			x2[i] -= x1[i];
		return x2;
	}

}
