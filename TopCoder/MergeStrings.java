package TopCoder;

import java.util.TreeSet;

public class MergeStrings {

	public static String S, A, B;
	static boolean flag = false;
	static StringBuilder sb;
static TreeSet<String> set=new TreeSet<String>();
	public static boolean check(String a) {
		for (int i = 0; i < a.length(); i++)
			if (a.charAt(i) != '?')
				return false;
		return true;
	}

	public static void rec(int startA, int startB) {
		// System.out.println(sb.toString() + " " + startA + " " + startB + " "
		// + S.charAt(startA + startB));

		if (startA >= A.length() || startB >= B.length()) {

			if (startA == A.length()) {
				if (check(S.substring(startA + startB))
						|| S.substring(startA + startB).equals(
								B.substring(startB))) {
					sb.append(B.substring(startB));
					set.add(sb.toString());
				}
			}
			if (startB == B.length()) {
				if (check(S.substring(startA + startB))
						|| S.substring(startA + startB).equals(
								A.substring(startA))) {
					sb.append(A.substring(startA));
					set.add(sb.toString());
				}
			}
			return;
		}

		int pos = startA + startB;
		int x = sb.length();
		if (S.charAt(pos) == '?') {

			sb.append(A.charAt(startA));
			rec(startA + 1, startB);
			sb.delete(x, sb.length());

			sb.append(B.charAt(startB));
			rec(startA, startB + 1);
			sb.delete(x, sb.length());

		} else {
			if (S.charAt(pos) == A.charAt(startA)) {
				sb.append(A.charAt(startA));
				rec(startA + 1, startB);
				sb.delete(x, sb.length());
			}
			if (S.charAt(pos) == B.charAt(startB)) {
				sb.append(B.charAt(startB));
				rec(startA, startB + 1);
				sb.delete(x, sb.length());
			}

		}

	}

	public static String getMin(String S, String A, String B) {
		MergeStrings.S = S;
		MergeStrings.A = A;
		MergeStrings.B = B;
		sb = new StringBuilder();
		rec(0, 0);
		return set.pollFirst();
	}

	public static void main(String args[]) {
		System.out.println(getMin("????K??????????????D???K???K????????K?????K???????",
				"KKKKKDKKKDKKDDKDDDKDKK",
				"KDKDDKKKDDKDDKKKDKDKKDDDDDDD"));
	}

}
