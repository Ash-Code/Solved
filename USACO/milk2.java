

/*
 ID: renegad2
 LANG: JAVA
 TASK: milk2
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class milk2 {

	public static class node implements Comparable<node> {
		int start, end;

		public node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(node a) {
			if (this.start > a.start)
				return +1;
			if (start < a.start)
				return -1;
			else
				return 0;
		}

	}

	// similar to the beads problem.. but way simpler. Added the intervals acc
	// to their start times, and keep extending the current time if the polled
	// interval intersects. if not, analyze the interval and change the current
	// interval

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk2.out")));
		int N = Integer.parseInt(bf.readLine()), a = 0, b = 0, ul, start, lapse = 0, max2 = 0, feed = 0, max1 = 0;
		TreeSet<node> set = new TreeSet<node>();
		StreamTokenizer st = new StreamTokenizer(bf);
		for (int i = 0; i < N; i++) {
			st.nextToken();
			a = (int) st.nval;
			st.nextToken();
			b = (int) st.nval;
			set.add(new node(a, b));

		}

		node n = set.pollFirst();
		start = n.start;
		ul = n.end;
max1=ul-start;
		max2=0;
		while (!set.isEmpty()) {
			n = set.pollFirst();
			if (n.start <=ul) {
				ul = Math.max(ul, n.end);
				continue;
			}
			feed = ul - start;
			if (feed > max1) {
				max1 = feed;
			}
			lapse = n.start - ul;
			start = n.start;
			ul = n.end;
			if (lapse > max2) {
				max2 = lapse;
			}

		}
		String res = max1 + " " + max2;

		pw.println(res);

		pw.close();
		System.exit(0);
	}
}
