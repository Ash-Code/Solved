package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeWords {

	public static int same(char[] in, int N) {
		int sum = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == '1')
				sum += (i + 1);
		}

		return sum % (N + 1);
	}

	public static int smaller(char[] in, int N) {
		int[] nos = new int[in.length];
		int sum = in[in.length - 1] == '0' ? 0 : in.length;
		nos[in.length - 1] = in[in.length - 1] == '0' ? 0 : 1;
		for (int i = in.length - 2; i >= 0; i--) {
			nos[i] = nos[i + 1];
			if (in[i] == '1') {
				sum += (i + 1);
				nos[i]++;
			}

		}

		for (int i = 0; i < in.length; i++) {
			if ((sum + nos[i]) % (N + 1) == 0) {

				return -1 * (i + 1);
			}
			if ((sum + nos[i] + i + 1) % (N + 1) == 0) {

				return i + 1;
			}
		}

		if ((sum + N) % (N + 1) == 0)
			return N;

		return -N;
	}

	public static int larger(char[] in, int N) {
		int[] nos = new int[in.length + 1];
		int sum = in[in.length - 1] == '0' ? 0 : in.length;
		nos[in.length - 1] = in[in.length - 1] == '0' ? 0 : 1;
		for (int i = in.length - 2; i >= 0; i--) {
			nos[i] = nos[i + 1];
			if (in[i] == '1') {
				sum += (i + 1);
				nos[i]++;
			}
		}

		for (int i = 0; i < in.length; i++) {
			if (in[i] == '1') {
				if ((sum - nos[i + 1] - i - 1) % (N + 1) == 0) {
					return i + 1;
				}
			} else {
				if ((sum - nos[i + 1]) % (N + 1) == 0) {
					return i + 1;
				}
			}
		}

		return 0;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuild = new StringBuilder();
		int N = Integer.parseInt(bf.readLine().trim());
		while (bf.ready()) {
			sBuild.append(bf.readLine()).append("\n");
		}

		String[] list = sBuild.toString().split("\n");

		for (String in : list) {

			in = in.replaceAll(" ", "");
			if (in.isEmpty())
				continue;
			char[] seq = in.toCharArray();
			if (in.length() == N) {

				int pos = same(seq, N);

				if (pos > 0) {
					pos--;
					seq[pos] = '0';
				}
				System.out.println(new String(seq));

			} else if (in.length() < N) {

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
				System.out.println(sb.toString());

			} else if (in.length() > N) {

				int pos = larger(seq, N);

				StringBuilder sb = new StringBuilder();
				pos--;
				sb.append(in.substring(0, pos));
				sb.append(in.substring(pos + 1));
				System.out.println(sb.toString());

			}

		}

	}

}
