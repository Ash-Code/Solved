package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/*
ID: renegad2
LANG: JAVA
TASK: runaround
*/
public class runaround {
	public static PrintWriter pw;

	public static boolean run(char[] in) {
		int n = in.length;
		int s = (in[0] - 48) % n;
		
		int[] f = new int[10];

		for(int i=0;i<in.length;i++){
			int num = in[s] - 48;
			f[num]++;
			if(num==0||f[num]>1)
				return false;
			s = (s + num) % n;
		}

		

		return true;
	}

	public static int Solve(int N) {

		for (int i = N + 1;; i++) {
			char[] arr = Integer.toString(i).toCharArray();
			
			if (run(arr)) {
				return i;

			}

		}

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int N = (int) st.nval;
		
		System.out.println(Solve(N));
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
