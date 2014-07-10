package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CodeWords {

	public static int same(char[] in, int N) {
	
		for(int i=0;i<in.length;i++){
			
		}
		return 0;
	}

	public static int smaller(char[] in, int N) {
		return 0;
	}

	public static int larger(char[] in, int N) {
		return 0;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<String> res = new ArrayList<String>();
		int N = Integer.parseInt(bf.readLine());
		String in = bf.readLine();
		while (!in.equals(null)) {
			char[] seq = in.toCharArray();
			if (in.length() == N) {
				int pos = same(seq, N);
				if (pos > 0) {
					pos--;
					seq[pos] = (char) ('1' - (seq[pos]));
				}
				res.add(new String(seq));
			}

			if (in.length() < N) {
				int pos = smaller(seq, N);
				StringBuilder sb = new StringBuilder();
				if (pos > 0) {
					pos--;
					sb.append(in.substring(0, pos));
					sb.append('1');
					sb.append(in.substring(pos));
				}
				if (pos < 0) {
					pos *= -1;
					pos--;
					sb.append(in.substring(0, pos));
					sb.append('0');
					sb.append(in.substring(pos));
				}
				res.add(sb.toString());

			}
			if (in.length() > N) {
				int pos = larger(seq, N);
				StringBuilder sb = new StringBuilder();
				pos--;
				sb.append(in.substring(0, pos));
				sb.append(in.substring(pos + 1));

				res.add(sb.toString());

			}

		}

	}

}
