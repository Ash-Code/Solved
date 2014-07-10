package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Brackets {
	static int[][] dp = new int[101][101];
	static LinkedList<Character> list;
	static char[] ori;
	public static HashMap<Character, Character> map;
	static int[][] add;
	static ArrayList<edit> edits = new ArrayList<edit>();

	public static class edit {
		int pos;
		char ed;

		public edit(int p, char e) {
			pos = p;
			ed = e;
		}
	}

	public static int rec(int s, int e) {
		if (s > e) {
			return 0;
		}

		if (dp[s][e] != -1) {
			// System.out.println("       called " + s + " " + e);
			return dp[s][e];
		}
		dp[s][e] = Integer.MAX_VALUE;
		int res = dp[s][e];
		int pos = s;
		if (ori[s] == ']' || ori[s] == ')') {
			res = 1 + rec(s + 1, e);
			pos = s;// special case, otherwise, we insert at position pos+1.
		} else {
			for (int i = s; i <= e; i++) {
				int min = 0;
				if (ori[i] != map.get(ori[s])) {
					min = 1 + rec(s + 1, i) + rec(i + 1, e);
				} else {
					min = rec(s + 1, i - 1) + rec(i + 1, e);
				}
				if (min < res) {
					res = min;
					pos = i;
				}
			}

		}
		if (ori[s] == ']' || ori[s] == ')') {// this marks what position to mark
												// and what item must be there.
												// negative means no adding
												// required
			add[s][e] = pos;
		} else {
			if (ori[pos] == map.get(ori[s])) {
				add[s][e] = -pos;
			} else {
				add[s][e] = pos + 1;
			}
		}
		dp[s][e] = res;
		// System.out.println(s + " " + e + " " + add[s][e]);
		return dp[s][e];
	}

	public static void mark(int s, int e) {

		if (s > e)
			return;
		// System.out.println("----mark----" + s + " " + e + " " +
		// map.get(ori[s])
		// + " " + add[s][e]);
		if (add[s][e] >= 0) {
			edits.add(new edit(add[s][e], map.get(ori[s])));
		}
		int pos = add[s][e];
		if (add[s][e] < 0) {
			pos = Math.abs(add[s][e]);
			mark(s + 1, pos - 1);
			mark(pos + 1, e);
		} else {
			if (add[s][e] == 200)
				return;
			if (pos == s) {
				mark(pos + 1, e);
				return;
			}
			/*
			 * for (char c : list) System.out.print(c); System.out.println("");
			 */
			if (pos != s + 1)
				mark(s + 1, pos - 1);
			mark(pos, e);

		}

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put(']', '[');
		map.put(')', '(');
		add = new int[101][101];
		String in = bf.readLine();
		list = new LinkedList<Character>();
		ori = in.toCharArray();
		for (char c : ori) {
			list.add(c);
		}

		for (int i = 0; i < 101; i++) {
			Arrays.fill(add[i], 200);
			Arrays.fill(dp[i], -1);
		}
		int length = rec(0, ori.length - 1);
		// System.out.println(length + " " + ori.length);

		/*
		 * for (int i = 0; i < ori.length; i++) for (int j = i; j < ori.length;
		 * j++) System.out.println(i + " " + j + " " + add[i][j]);
		 */
		mark(0, ori.length - 1);
		for (int x = edits.size() - 1; x >= 0; x--) {
			edit temp = edits.get(x);
			list.add(temp.pos, temp.ed);
		}

		for (char c : list) {
			System.out.print(c);
		}

	}
}
