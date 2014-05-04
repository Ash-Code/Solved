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
public class comehome {
	public static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int n = (int) st.nval;

		
		
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
