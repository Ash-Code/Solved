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
 TASK: sort3
 */

public class sort3 {
	// my solution is quite strange compared to the analysis. First place all
	// the nums where they should be with one swap
	// i.e. if a 2's section has 1 then swap that 1 with a 2 in 1's section. Now
	// there can be many 2s left in 1 section and no 1 left in 2's section,
	// that means those 2's require 2 swaps and we can place them in 3's section
	// for later swap. Do the same with 3's section

	public static int[] list;
	static int count = 0;

	public static void swap(int i, int j) {

		count++;
		System.out.println("swapping " + list[i] + " @ " + i + " with "
				+ list[j] + " @ " + j + " " + count);
		int t = list[j];
		list[j] = list[i];
		list[i] = t;

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();
		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));
		StreamTokenizer st = new StreamTokenizer(bf);
		st.nextToken();
		int N = (int) st.nval;
		list = new int[N];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			list[i] = (int) st.nval;

		}
		System.out.println("");
		for (int x = 0; x < list.length; x++) {
			System.out.print(list[x] + " ");
		}
		System.out.println("");
		int c1 = 0, c2 = 0, c3 = 0;
		for (int i = 0; i < N; i++) {
			if (list[i] == 1)
				c1++;
			if (list[i] == 2)
				c2++;
			if (list[i] == 3)
				c3++;
		}
		System.out.println(c1 + " " + c2 + " " + c3);
		int i = 0, j3 = N - 1, j2 = N - c3 - 1;

		while (i < c1) {
			if (list[i] == 3) {

				for (; j3 > c1 - 1; j3--) {
					if (list[j3] == 1) {
						swap(i, j3);
						break;
					}
				}
			}
			if (list[i] == 2) {
				for (; j2 > c1 - 1; j2--) {

					if (list[j2] == 1) {
						swap(i, j2);
						break;
					}
					if (j2 == c1 && list[j2] != 1) {
						j2 = N;
					}
				}
			}
			i++;

		}

		System.out.println("");
		for (int x = 0; x < list.length; x++) {
			System.out.print(list[x] + " ");
		}
		System.out.println("");
		j3 = N - 1;
		while (i < c1 + c2) {

			if (list[i] == 3) {
				for (; j3 > c2 + c1 - 1; j3--) {
					if (list[j3] == 2) {
						swap(i, j3);
						break;
					}
				}
			}

			i++;

		}

		pw.println(count);
		pw.close();
		System.out.println("" + count);
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);

	}
}
