package TopCoder;
import java.util.ArrayList;

public class SubstringReversal {


	public String reverse(String S, int i, int j) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < i; x++)
			sb.append(S.charAt(x));
		for (int x = j; x >= i; x--)
			sb.append(S.charAt(x));
		for (int x = j + 1; x < S.length(); x++)
			sb.append(S.charAt(x));
		return sb.toString();
	}

	public int[] solve(String S) {
		ArrayList<Integer> revPos = new ArrayList<Integer>();
		char[] minRight = S.toCharArray();
		for (int i = S.length() - 2; i >= 0; i--) {
			minRight[i] = (char) Math.min(minRight[i], minRight[i + 1]);
		}
		int start = 0;
		while (start < S.length() && minRight[start] == S.charAt(start))
			start++;
		int[] answer = new int[2];
		if (start == S.length())
			return answer;
		int end = start + 1;
		String min = S;
		for (int j = start + 1; j < S.length(); j++) {
			if (S.charAt(j) == minRight[start]) {
				String temp = reverse(S, start, j);
				if (temp.compareTo(min) < 0) {
					min = temp;
					end = j;
				}
			}
		}
		answer[0] = start;
		answer[1] = end;
		return answer;

	}

}
