package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/*
 ID: renegad2
 LANG: JAVA
 TASK: zerosum
 */
public class zerosum {
	public static PrintWriter pw;
	static int N;
	static ArrayList<String> list = new ArrayList<String>();

	public static boolean check(String op) {
		int sum = 0;
		int val = 1;
		int x = 1;
		int sign = 1;
		for (int i = 0; i < op.length(); i++) {

			x = i + 1;

			if (op.charAt(i) == ' ') {
				val = val * 10 + (x + 1);
				continue;
			}
			if (op.charAt(i) == '+') {
				if (sign == 1)
					sum += val;
				if (sign == 2)
					sum -= val;
				sign = 1;
				val = x + 1;
			}
			if (op.charAt(i) == '-') {
				if (sign == 1)
					sum += val;
				if (sign == 2)
					sum -= val;
				sign = 2;
				val = x + 1;
			}

			//System.out.println(x + " " + val + " " + op.charAt(i) + " " + sum
				//	+ " " + sign);

		}
		x = op.length() + 1;
		if (op.charAt(op.length() - 1) == '+') {
			sum += x;
		} else if (op.charAt(op.length() - 1) == '-')
			sum -= x;
		else {
			if (sign == 1)
				sum += val;
			if (sign == 2)
				sum -= val;
		}
		//System.out.println(sum);
		if (sum == 0) {
			return true;
		}

		return false;

	}

	public static void rec(int n, String op) {

		if (n == (N)) {
			if (check(op)){
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<N;i++){
				sb.append(i);
				sb.append(op.charAt(i-1));
			}
			sb.append(N);
			
				list.add(sb.toString());
			}

			return;
		}

		rec(n + 1, op + " ");
		rec(n + 1, op + "+");
		rec(n + 1, op + "-");

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		N = (int) st.nval;
rec(1,"");
		for (String x : list) {
			pw.println(x);
		}
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
