package CodeProbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

public class Phone {

	public static class node implements Comparable<node> {

		int pos, ref, l;

		public node(int pos, int ref, int l) {
			this.pos = pos;

			this.ref = ref;
			this.l = l;

		}

		@Override
		public int compareTo(node n) {
			if (n.pos > pos)
				return -1;
			if (n.pos < pos)
				return 1;
			if (this.l > n.l)
				return -1;
			if (this.l < n.l)
				return 1;
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public static String solve(String number, String[] word) throws IOException {
		String numero = number, cut = "";

		TreeSet<node> pq = new TreeSet<node>();
		int maxi = 0, ref, pos, j = 0, length = number.length();
		boolean[] init = new boolean[length + 1];
		ArrayList<String> allWords = new ArrayList<String>();
		int[] dp = new int[length + 1];
		String[] res = new String[length + 1];

		for (int i = 0; i < word.length; i++)
			allWords.add(converter(word[i]));

		String max = "", temp = "", result = "";

		for (int i = 0; i < allWords.size(); i++) {
			temp = allWords.get(i);
			for (int x = 0; x < numero.length(); x++) {
				pos = x + numero.substring(x).indexOf(temp);
				if (pos - x > -1) {
					pq.add(new node(pos, i, temp.length()));
				}
			}

		}
		allWords = null;
		for (int i = 0; i <= length; i++) {
			res[i] = "";
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		init[0] = true;
		node t;
		int cp = 0, lp = 0;
		while (!pq.isEmpty()) {

			t = pq.pollFirst();
			cp = t.pos;
			if (cp + t.l <= length && init[cp] == true) {
				if (dp[cp + t.l] > (dp[cp] + 1)) {
					dp[cp + t.l] = dp[cp] + 1;
					init[cp + t.l] = true;
					res[cp + t.l] = res[cp] + " " + word[t.ref];
				}
			}

		}

		result = res[length];
		result.trim();
		if (result.length() == 0) {

			result = "No solution.";
		}

		return result;
	}

	public static String converter(String s) {
		String conv = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'i' || s.charAt(i) == 'j')
				conv += "1";
			else if (s.charAt(i) == 'a' || s.charAt(i) == 'b'
					|| s.charAt(i) == 'c')
				conv += "2";
			else if (s.charAt(i) == 'd' || s.charAt(i) == 'e'
					|| s.charAt(i) == 'f')
				conv += "3";
			else if (s.charAt(i) == 'g' || s.charAt(i) == 'h')
				conv += "4";
			else if (s.charAt(i) == 'k' || s.charAt(i) == 'l')
				conv += "5";
			else if (s.charAt(i) == 'm' || s.charAt(i) == 'n')
				conv += "6";
			else if (s.charAt(i) == 'p' || s.charAt(i) == 'r'
					|| s.charAt(i) == 's')
				conv += "7";
			else if (s.charAt(i) == 't' || s.charAt(i) == 'u'
					|| s.charAt(i) == 'v')
				conv += "8";
			else if (s.charAt(i) == 'w' || s.charAt(i) == 'x'
					|| s.charAt(i) == 'y')
				conv += "9";
			else
				conv += "0";
		}

		return conv;

	}

	public static void input() throws IOException {

		int b;
		String number = "", word[], res = "";

		BufferedReader bf = new BufferedReader(new FileReader("C:/data.txt"));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out,
				"ISO-8859-1"));
		String temp = "";
		temp = bf.readLine();

		while (temp.compareTo("-1") != 0) {

			number = temp;
			temp = bf.readLine();

			b = Integer.parseInt(temp);
			word = new String[b];
			int i = 0;
			while (i < b) {

				word[i] = bf.readLine();
				i++;

			}

			temp = bf.readLine();
			res = solve(number, word);
			System.out.println(res);
			word = null;
			number = "";
			b = 0;

		}
		bf.close();
	}

	public static void main(String[] args) throws IOException {

		input();
	}

}
