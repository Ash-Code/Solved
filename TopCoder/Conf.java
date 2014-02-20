package CodeProbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class Conf {

	public static boolean inter(int a, int b, int c, int d) {
		if ((a >= c && a <= d) || b >= c && b <= d)
			return true;
		return false;
	}

	public static class Node implements Comparable<Node> {

		int start, end;

		public Node(int s, int e) {
			this.start = s;
			this.end = e;
		}

		public int compareTo(Node n) {
			if (this.end > n.end)
				return 1;
			if (end < n.end)
				return -1;
			else if (start > n.start)
				return -1;
			else if (start < n.start)
				return +1;
			return 0;
		}

	}

	public static int Solve(int N, int start[], int end[]) {
		TreeSet<Node> pq = new TreeSet<Node>();

		for (int i = 0; i < N; i++) {
			pq.add(new Node(start[i], end[i]));
		}
		int res = 0, lastend = 0;
		Node n, last = pq.pollFirst();
		lastend = last.end;
		res++;
		ytre: while (!pq.isEmpty()) {
			n = pq.pollFirst();

			if (inter(n.start, n.end, last.start, last.end)
					|| n.start <= lastend) {

				continue ytre;
			}

			last = n;
			lastend = last.end;
			res++;
		}
		return res;
	}

	public static void input() throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new FileReader("C:/conf.txt")));

		int N, start[], end[];
		st.nextToken();
		N = (int) st.nval;

		start = new int[N];
		end = new int[N];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			start[i] = (int) st.nval;
			st.nextToken();
			end[i] = (int) st.nval;
		}

		System.out.println(Solve(N, start, end));
	}

	public static void main(String args[]) throws IOException {
		input();
	}

}
