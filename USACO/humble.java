package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/*
 ID: renegad2
 LANG: JAVA
 TASK: humble
 */
public class humble {
	public static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int k = (int) st.nval;
		st.nextToken();
		int n = (int) st.nval;
		long[] list = new long[k];
		TreeSet<Long> set = new TreeSet<Long>();
		ArrayList<Long> curr = new ArrayList<Long>();
		TreeSet<Long> prods = new TreeSet<Long>();
		for (int i = 0; i < k; i++) {
			st.nextToken();
			list[i] = (long) st.nval;
			curr.add(list[i]);
		}
		Arrays.sort(list);
		set.addAll(curr);
		while (set.size() < 2000) {
			for (long x : list) {
				for (long c : curr) {
					prods.add(x * c);
				}
			}
			curr.clear();
			curr.addAll(prods);
			set.addAll(prods);
			prods.clear();
		}
		System.out.println(set.toString());
		Iterator<Long> it = set.iterator();
		int c = 0;
		while (c < n - 1) {
			it.next();
			c++;
		}

		System.out.println(it.next());
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
