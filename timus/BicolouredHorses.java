package CodeProbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Iterator;
import java.util.TreeSet;

public class BicolouredHorses {

	public static class node implements Comparable<node> {
		int coeff, unhappy, i, j;

		public node(int coeff, int unhappy, int i, int j) {
			this.coeff = coeff;
			this.unhappy = unhappy;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(node n) {
			if (coeff > n.coeff)
				return -1;
			if (coeff < n.coeff)
				return +1;
			if (unhappy > n.unhappy)
				return -1;
			if (unhappy < n.unhappy)
				return 1;
			if (i > n.i)
				return 1;
			if (i < n.i)
				return -1;

			else
				return 0;
		}

	}

	public static int Solve(int H, int K, int[] horses) {
		int size = horses.length, result = 0;
		node dp[][] = new node[size][size];
		int x = 0, c = 0, templeft = 0, tempright = 0, count = 0, left1 = 0, left0 = 0, right1 = 0, right0 = 0, bad = 1000000000,mbl=1000000000,mbr=1000000000, badl = 0, badr = 0, cleft = 0, cright = 0, temp = 0, l = 0, r = 0;
		boolean right = false, left = false;
		TreeSet<node> pq = new TreeSet<node>();
		if (K == 0)
			return 0;
		for (int i = 0; i <= size - 1; i++) {
			right1 = right0 = 0;
			if (horses[i] == 1)
				left1++;
			if (horses[i] == 0)
				left0++;

		}

		templeft = (left1 * left0);

		pq.add(new node(0, templeft, 0, size - 1));
		node t;
		while (c < K - 1) {
			t = pq.pollFirst();
			x = (t.j - t.i) / 2;

			left1 = left0 = 0;
			for (int i = t.i; i <= t.j; i++) {
				right1 = right0 = 0;
				if (horses[i] == 1)
					left1++;
				if (horses[i] == 0)
					left0++;
				for (int j = i + 1; j <= t.j; j++) {

					if (horses[j] == 1) {

						right1++;

					}
					if (horses[j] == 0) {
						right0++;

					}
				}

				templeft = (left1 * left0);
				tempright = (right1 * right0);
				temp = templeft + tempright;

				if (bad > temp) {
					bad = temp;
					badl = templeft;
					badr = tempright;
					x = i;
				}

			}
			
			
			left1 = left0 = 0;
			for (int i = t.i; i <= x; i++) {
				right1 = right0 = 0;
				if (horses[i] == 1)
					left1++;
				if (horses[i] == 0)
					left0++;
				for (int j = i + 1; j <= x; j++) {

					if (horses[j] == 1) {

						right1++;

					}
					if (horses[j] == 0) {
						right0++;

					}
				}

				templeft = (left1 * left0);
				tempright = (right1 * right0);
				temp = templeft + tempright;

				if (mbl > temp) {
					mbl = temp;
					
				}

			}
			
			
			left1 = left0 = 0;
			for (int i = x+1; i <= t.j; i++) {
				right1 = right0 = 0;
				if (horses[i] == 1)
					left1++;
				if (horses[i] == 0)
					left0++;
				for (int j = i + 1; j <= t.j; j++) {

					if (horses[j] == 1) {

						right1++;

					}
					if (horses[j] == 0) {
						right0++;

					}
				}

				templeft = (left1 * left0);
				tempright = (right1 * right0);
				temp = templeft + tempright;

				if (mbr > temp) {
					mbr = temp;
					
				}

			}
			
			

			cleft = (badl-mbl) * (x - t.i + 1);
			cright = (badr-mbr) * (t.j - t.i);
			pq.add(new node(cleft, badl, t.i, x));
			pq.add(new node(cright, badr, x + 1, t.j));
			c++;
		}

		Iterator<node> it = pq.iterator();
		while (it.hasNext()) {
			t = it.next();
			result += t.unhappy;
		}

		return result;

	}

	public static void input() throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new FileReader("C:/text.txt")));

		int H, K, horses[];
		st.nextToken();
		H = (int) st.nval;

		st.nextToken();
		K = (int) st.nval;

		horses = new int[H];
		for (int i = 0; i < H; i++) {
			st.nextToken();
			horses[i] = (int) st.nval;
		}

		System.out.println(Solve(H, K, horses));
	}

	public static void main(String args[]) throws IOException {
		input();

	}

}
