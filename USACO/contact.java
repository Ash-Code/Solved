package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/*
 ID: renegad2
 LANG: JAVA
 TASK: contact
 */
public class contact {
	public static PrintWriter out;
	public static HashMap<String, Integer> map;

	static class BinString implements Comparable<BinString> {
		String pat;
		int val;

		public BinString(String in) {
			pat = in;
			val = Integer.parseInt(pat, 2);
		}

		@Override
		public int compareTo(BinString a) {
			if (a.pat.length() > pat.length())
				return -1;
			if (a.pat.length() < pat.length())
				return +1;
			else
				return a.val > val ? -1 : 1;
		}
	}

	public static void Solve(String in, int A, int B) {
		for (int i = A; i <= B; i++) {
			for (int j = 0; j + i - 1 < in.length(); j++) {

				String curr = in.substring(j, j + i);
				// System.out.println("  " + curr);
				if (map.containsKey(curr)) {
					map.put(curr, map.get(curr) + 1);
				} else {
					map.put(curr, 1);
				}

			}
		}

	}

	public static void print(int N) {
		ArrayList<Integer> freq = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<BinString>> fmap = new HashMap<Integer, ArrayList<BinString>>();
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();
		while (it.hasNext()) {
			Entry<String, Integer> temp = it.next();
			if (fmap.containsKey(temp.getValue())) {
				fmap.get(temp.getValue()).add(new BinString(temp.getKey()));
			} else {
				freq.add(temp.getValue());
				ArrayList<BinString> tt = new ArrayList<BinString>();
				tt.add(new BinString(temp.getKey()));
				fmap.put(temp.getValue(), tt);

			}
		}

		Collections.sort(freq);
		int n = freq.size();
		int lim = N >= n ? 0 : n - N;
		for (int i = n - 1; i >= lim; i--) {
			out.println(freq.get(i));
			ArrayList<BinString> temp = fmap.get(freq.get(i));
			Collections.sort(temp);
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (BinString y : temp) {
				String x = y.pat;
				if (count > 5) {
					count = 0;
					out.println(sb.toString().trim());
					sb = new StringBuilder();
				}
				count++;
				sb.append(x).append(" ");
			}
			out.println(sb.toString().trim());

		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (bf.ready()) {
			sb.append(bf.readLine());
		}
		String in = sb.toString();
		map = new HashMap<String, Integer>();

		Solve(in, A, B);
		print(n);
		// System.out.println(map.toString());

		out.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
