package USACO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/*
 ID: renegad2
 LANG: JAVA
 TASK: fracdec
 */
public class fracdec {
	public static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new FileWriter("C:/ride.out"));
		Scanner sc = new Scanner(bf);
		int n = sc.nextInt();
		int N = n;
		int D = sc.nextInt();
		long time = System.currentTimeMillis();
		int rem = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		StringBuilder sb = new StringBuilder();
		sb.append(N / D).append('.');
		N = 10 * (N % D);
		int pos = sb.length() - 1;
		boolean div = false;
		while (!map.containsKey(N)) {
			// System.out.println("  "+N+" / "+D+"  appending "+(N/D)+
			// " rem: "+(N%D));
			sb.append(N / D);
			rem = N % D;
			if (rem == 0) {
				div = true;
				break;
			}
			pos = sb.length() - 1;
			map.put(N, pos);
			N = rem * 10;
		}
		if (!div) {
			
			sb.append(')');
			int x = map.get(N);
			sb.insert(x, (char) '(');
		}
		String res = sb.toString();
		while (!res.equals("")) {
			pw.println(res.substring(0, Math.min(res.length(), 76)));
			if (res.length() <= 76)
				res = "";
			else
				res = res.substring(76);
		}
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
