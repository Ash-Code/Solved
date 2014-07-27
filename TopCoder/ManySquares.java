package TopCoder;
import java.util.Arrays;

public class ManySquares {

	public int howManySquares(int[] sticks) {
		Arrays.sort(sticks);
		int last = sticks[0];
		int c = 1;
		int res = 0;
		for (int i = 1; i < sticks.length; i++) {
			

			if (sticks[i] == last)
				c++;
			else {
				last = sticks[i];
				c = 1;
			}
			if (c == 4) {
				res++;
				c = 0;
			}
		}

		return res;
	}

}
