package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class C261D {
	static BufferedReader bf;
	static PrintWriter pw;

	public void Solve() {

	}

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		StreamTokenizer st = new StreamTokenizer(bf);
		Scanner ss = new Scanner(System.in);
		st.nextToken();
		int n = (int) st.nval;
		int[] a = new int[n];
		int[] aux = new int[n];
		int[] aux2 = new int[n];
		for (int i = 0; i < n; i++) {
			st.nextToken();
			a[i] = (int) st.nval;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (a[j] == a[i])
					aux[i]++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (a[j] == a[i])
					aux2[i]++;
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (aux[i] > aux2[j])
					res++;
			}
		}
		System.out.println(res);
		bf.close();
		pw.close();

	}
}
