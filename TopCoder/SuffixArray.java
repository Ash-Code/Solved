package TopCoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SuffixArray {
//MY FIRST DIV2 LVL 3 PROBLEM SOLVED AT FIRST GO!!!
	//WOOOOOOOOOOOOHOOOOOOOOOO!!
	//SOLVED ON 3rd September 2014
	//Thinking time = 19 min
	public static class node implements Comparable<node> {
		String val;
		int id;

		public node(int i, String v) {
			id = i;
			val = v;
		}

		@Override
		public int compareTo(node x) {
			return this.val.compareTo(x.val);
		}
	}

	static String smallOne(String a) {

		node[] suffix = new node[a.length()];
		for (int i = 0; i < a.length(); i++) {
			suffix[i] = new node(i, a.substring(i));
		}
		Arrays.sort(suffix);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int c = 0;
		for (node x : suffix) {
			map.put(x.id, c);
			c++;
		}
		boolean ok = false;
		for (node x : suffix) {
			String curr = x.val;
			for (int i = 0; i < curr.length(); i++) {
				boolean tOk = true;
				int actP = x.id + i;
				if (curr.charAt(i) == 'a')
					continue;
				char n = curr.charAt(i);
				--n;
				for (int j = 0; j <= actP; j++) {
					int pos = map.get(j);
					if (pos == 0)
						continue;
					int valP = actP - j;
					char[] temp = suffix[pos].val.toCharArray();
					temp[valP] = n;
					String tt = new String(temp);
					if (suffix[pos - 1].val.compareTo(tt) > 0) {
						tOk = false;
					}

				}
				if (tOk) {
					return "Exists";
				}

			}

		}

		return "Does not exists";
	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		String a=ss.next();
		System.out
				.println(smallOne(a));

	}

}
