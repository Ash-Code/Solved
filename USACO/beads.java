// the idea is to record when the sequence changes. Use the current max contiuous length and the max possible previous length ( generated using the whiteList(wl1)) to produce total length
// the maximum of which is taken.
/*
 ID: renegad2
 LANG: JAVA
 TASK: beads
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class beads {

	
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("beads.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		int N = Integer.parseInt(bf.readLine());
		String nl = bf.readLine();
		char[] lace = nl.toCharArray();
		int pos = 0, start = 0, l = 0, wl2 = 0, wl1 = 0, max = 0, prev = 0, next = 0, count = 0, go = ((int) lace.length * 2), d2 = -2, d1 = -1;
		boolean fork = false;
		char a=lace[0];
		while (pos < lace.length && (lace[pos] == 'w' || lace[pos] == lace[0]))
			pos++;

		if (pos == lace.length) {
			max = lace.length;
		} else
			a = lace[pos];
		
		start = pos;

		while (count < go) {
if(pos==lace.length)
				break;
			if (start == pos&&count!=0) {
				break;
			}
			count++;
			if (start == N)
				start %= N;
			d1 = -1;
			d2 = -2;

			if (start == 0) {
				d1 = N - 1;
				d2 = N - 2;
			}
			if (start == 1) {
				d1 = -1;
				d2 = N - 2;
			}

			if (lace[start] == 'w' || lace[start] == a) {

				next++;

				if (lace[start] == 'w') {
					if (lace[start + d1] == 'w')
						wl2++;
					else
						wl2 = 1;
				} else
					wl2 = 0;
				start++;
				continue;

			}

			a = lace[start];

			l = prev + next;
			if (l > max) {
				max = l;
				pos = start;
			}

			prev = next + wl1;
			next = 1;
			wl1 = wl2;

			start++;

		}

		
		pw.println(max);

		pw.close();
		System.exit(0);
	}
}
