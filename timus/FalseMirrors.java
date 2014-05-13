package timus;

import java.util.Arrays;
import java.util.Scanner;

public class FalseMirrors {
	static boolean[] pos;
	static int end, total, N, res = Integer.MAX_VALUE;
	static int[] damage, memo;
//more of a memo problem. Quick way to store states and optimum sols for states in masks.
	public static int shots(int mask) {
		// System.out.println(Integer.toBinaryString(mask)+" "+Integer.toBinaryString(end));

		if (mask == end) {
			// System.out.println("   reached");
			
			return 0;
		}
		if (memo[mask] != -1)
			return memo[mask];
		memo[mask]=0;
		int total=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if ((mask & (1 << i)) == 0) {
				int back = mask;
				int ss = 0;
				for (int j = i; j < i + 3; j++) {

					back |= (1 << (j % N));
				}
				ss = damage[back]+ shots(back);
				if(ss<total){
					total=ss;
				}
			}
		}
		memo[mask]=total;
		return memo[mask];

	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		N = ss.nextInt();
		int[] in = new int[N];

		// System.out.println(1<<(N));
		damage = new int[(1 << (N))];
		memo = new int[(1 << N)];
		Arrays.fill(memo, -1);
		end = (1 << (N)) - 1;
		for (int i = 0; i < N; i++) {
			in[i] = ss.nextInt();
		}
		for (int mask = 0; mask <= end; mask++) {
			for (int i = 0; i < N; i++) {
				if ((mask & (1 << i)) == 0) {
					damage[mask] += in[i];
				}
			}
		}

		shots(0);
		System.out.println(memo[0]);
	}

}
