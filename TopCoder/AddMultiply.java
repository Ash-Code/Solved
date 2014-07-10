package TopCoder;
public class AddMultiply {

	public int[] makeExpression(int y) {
		int[] x = new int[3];
		x[0] = 2;
		x[1] = 2;
		x[2] = y - 4;
		if (y == 0) {
			x[2] = -4;
		}
		if (y == 1)
			x[2] = -3;
		if (y == 2)
			x[2] = -2;
		if (y == 3) {
			x[1] = 3;
			x[2] = -3;
		}
		if (y == 4) {
			x[1] = 3;
			x[2] = -2;
		}
		if (y == 5) {
			x[1] = 4;
			x[2] = -3;
		}

		return x;
	}

}
