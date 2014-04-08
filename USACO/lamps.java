package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/*
 ID: renegad2
 LANG: JAVA
 TASK: lamps
 */

public class lamps {
	public static PrintWriter pw;
	static int N;
	static boolean odeve;
	static TreeSet<String> res = new TreeSet<String>();
	static ArrayList<Integer> On;
	static ArrayList<Integer> Off;

	public static boolean check() {
		return false;
	}

	public static boolean[] one(boolean map[]) {

		for (int i = 0; i < N; i++)
			map[i] = !map[i];

		return map;
	}

	public static boolean[] two(boolean map[]) {
		for (int i = 0; i < N; i += 2)
			map[i] = !map[i];
		return map;
	}

	public static boolean[] three(boolean map[]) {
		for (int i = 1; i < N; i += 2)
			map[i] = !map[i];
		return map;
	}

	public static boolean[] four(boolean[] map) {
		for (int i = 0; i < N; i += 3)
			map[i] = !map[i];
		return map;

	}

	public static boolean check(boolean[] map) {
		for (int i = 0; i < On.size(); i++) {
			int x = On.get(i);
			x--;
			if (!map[x])
				return false;
		}
		for (int i = 0; i < Off.size(); i++) {
			int x = Off.get(i);
			x--;
			if (map[x])
				return false;
		}

		return true;
	}
static Stack<Integer> s=new Stack<Integer>();
public static void rec(boolean[] map, int C) {

		if (C == 0) {
			if (check(map)) {
				StringBuilder sb=new StringBuilder();
				for (int i = 0; i < N; i++){
					if(map[i])
						sb.append('1');
					else
						sb.append('0');
				}
			

				if(res.add(sb.toString())){
					System.out.print(sb.toString()+" ");
					for(int i:s){
						System.out.print(i);
					}
					System.out.println("");
				}

			}
			return;
		}
s.add(1);
		rec(one(map), C - 1);
		s.pop();
		one(map);
		s.add(2);
		rec(two(map), C - 1);
		two(map);
		s.pop();
	s.add(3);
		rec(three(map), C - 1);
		three(map);
		s.pop();
		s.add(4);
		rec(four(map), C - 1);
		four(map);
		s.pop();
	}

	public static void init() throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		N = (int) st.nval;

		st.nextToken();
		int C = (int) st.nval;
		On = new ArrayList<Integer>();
		Off = new ArrayList<Integer>();
		while (true) {
			st.nextToken();
			if (st.nval == -1)
				break;
			On.add((int) st.nval);
		}
		st.nextToken();
		while (true) {
			if (st.nval == -1)
				break;
			Off.add((int) st.nval);
			st.nextToken();
		}
		boolean map[] = new boolean[N];
		one(map);

		if (C >4) {
if(C%2==0){
	C=4;
}else
	C=3;
		}
System.out.println(250%4);
		rec(map, 4);

		if (res.size() == 0) {
			pw.println("IMPOSSIBLE");
		} else
			for (String x : res) {
				System.out.println(x);
			
			}

		pw.close();
	}

	public static void main(String args[]) throws IOException {
		init();
		long time = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
