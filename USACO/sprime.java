package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: renegad2
LANG: JAVA
TASK: sprime
*/
public class sprime {

	public static PrintWriter pw;
	public static int N = 0;

	public static boolean check(int a) {
		if (a <= 1)
			return false;
		int lim = ((int) Math.sqrt(a));
		boolean p = true;
		for (int i = 2; i <= lim; i++) {
			if (a % i == 0) {
				p = false;
				break;
			}
		}

		return p;
	}

	public static void dfs(int a, int l) {
		int c = 0;
		if (l > N) {
			pw.println(a);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			c = a * 10 + i;
			if (check(c)) {
				dfs(c, l + 1);
			}
		}

	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		N = Integer.parseInt(bf.readLine());
		bf.close();
		dfs(0, 1);
		pw.close();
		System.exit(0);

	}

}
