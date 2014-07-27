package TopCoder;
public class BishopMove {

	public boolean isWhite(int r, int c) {
		if (r % 2 == 0) {
			if (c % 2 == 0)
				return true;
		}
		if (r % 2 == 1)
			if (c % 2 == 1)
				return true;
		return false;
	}

	public boolean check(int r1, int c1, int r2, int c2) {
		int k1 = Math.abs(r1 - r2);
		int k2 = Math.abs(c1 - c2);
		if (k1 == k2)
			return true;
		return false;
	}

	public int howManyMoves(int r1, int c1, int r2, int c2) {
		r1++;
		r2++;
		c1++;
		c2++;
		if (r1 == r2 && c1 == c2)
			return 0;
		if (isWhite(r1, c1)) {
			if (isWhite(r2, c2)) {
				if (check(r1, c1, r2, c2))
					return 1;
				else
					return 2;
			}
		} else {

			if (!isWhite(r2, c2)) {
				if (check(r1, c1, r2, c2))
					return 1;
				else
					return 2;
			}

		}

		return -1;
	}

}
