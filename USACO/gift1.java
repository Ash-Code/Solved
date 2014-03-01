

/*
 ID: renegad2
 LANG: JAVA
 TASK: gift1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class gift1{

	public static int get(String a) {
		int res = 1;
		for (int i = 0; i < a.length(); i++)
			res *= (a.charAt(i) - 64);

		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));

		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;
		String[] names = new String[n];
		HashMap<String, Integer> map = new HashMap();
		HashMap<String, Integer> init = new HashMap();
		for (int i = 0; i < n; i++) {
			st.nextToken();
			map.put(st.sval, 0);
			names[i] = st.sval;
		}
		for (int i = 0; i < n; i++) {
			st.nextToken();
			String name = st.sval;
			
			st.nextToken();
			int money = (int) st.nval;
			init.put(name, money);
			st.nextToken();
			int x = (int) st.nval;
			if (x == 0)
				continue;
			int don = money / x;
			for (int j = 0; j < x; j++) {
				st.nextToken();
				String ndior = st.sval;
				map.put(ndior, map.get(ndior) + don);
			}
			map.put(name, map.get(name) + money % x);

		}
		for (String a : names) {
			init.put(a, map.get(a) - init.get(a));
			pw.println(a + " " + init.get(a));
		}

		pw.close();
		System.exit(0);
	}
}
