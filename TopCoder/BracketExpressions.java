package TopCoder;
import java.util.ArrayList;

public class BracketExpressions {

	static int[][] dp;

	public static boolean isRight(String s, int start, int end) {
		// System.out.println(s);
		if (dp[start][end] != 0)
			return dp[start][end] == 1;
		if(start>end)
			return true;
		if (start == end)
			return false;
		

		char a = s.charAt(start);
		char b = a;
		if (a == '{')
			b = '}';
		if (a == '[')
			b = ']';
		if (a == '(')
			b = ')';
		if (!(a == '{' || a == '[' || a == '(')) {
			return false;
		}
		 //System.out.println("  should  " + a+" "+b);
		boolean ok = false;
		for (int i = start+1; i <=end; i++) {
			if (ok)
				return ok;
			if (s.charAt(i) == b) {
				//System.out.println("         found at " +i);
				if (i != end)
					ok = (isRight(s,start+1, i-1)) && isRight(s,
							i+1,end);
				else
					ok = isRight(s,start+1, end-1);
			}
		}
		
		dp[start][end]=ok?1:-1;
		
		return ok;

	}

	public static String ifPossible(String exp) {

		char[] temp = exp.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		boolean found = false;
		list.add(exp);
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 'X') {
				found = true;
				ArrayList<String> tt = new ArrayList<String>();
				if (!list.isEmpty()) {
					for (String x : list) {
						char[] in = x.toCharArray();
						in[i] = '{';
						tt.add(new String(in));
						in[i] = '}';
						tt.add(new String(in));
						in[i] = '[';
						tt.add(new String(in));
						in[i] = ']';
						tt.add(new String(in));
						in[i] = '(';
						tt.add(new String(in));
						in[i] = ')';
						tt.add(new String(in));

					}

				}
				list.clear();
				list.addAll(tt);
				tt.clear();

			}
		}
		if (!found)
			list.add(exp);

		boolean possible = false;
		for (String s : list) {
			dp = new int[s.length()][s.length()];
			if (isRight(s, 0, s.length() - 1)) {
				possible = true;
				break;
			}
		}

		return possible ? "possible" : "impossible";
	}

	public static void main(String args[]) {
		System.out
				.println(ifPossible("({])"));

	}

}
