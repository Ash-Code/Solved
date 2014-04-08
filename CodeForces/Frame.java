package CodeForces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Frame {
	static PrintWriter pw;

	public static void Solve() {

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();

		bf.close();

		pw.close();
		System.exit(0);

	}
}