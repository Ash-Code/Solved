package TopCoder;
public class RectangleCoveringEasy {

	public int solve(int holeH, int holeW, int boardH, int boardW) {
		int a = Math.min(holeH, holeW);
		int b = Math.max(holeH, holeW);
		int ba = Math.min(boardW, boardH);
		int bb = Math.max(boardW, boardH);
		if (a < ba && b < bb)
			return 1;

		if (a == ba && b < bb)
			return 1;
		if (a < ba && b == bb)
			return 1;

		return -1;
	}

}
