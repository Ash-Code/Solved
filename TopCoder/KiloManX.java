package CodeProbs;

import java.util.TreeSet;

public class KiloManX {

	public static class node implements Comparable<node> {
		int weapon;
		int shots = 0;

		public node(int weapon, int shots) {
			this.weapon = weapon;
			this.shots = shots;
		}

		@Override
		public int compareTo(node n) {
			if (n.shots < shots)// put an equal to here, same weapon config and
								// same shots can be reached differently.
				return 1;
			if (n.shots > shots)
				return -1;
			if (n.weapon > weapon)
				return -1;
			if (n.weapon < weapon)
				return 1;
			else
				return 0;
		}

	}

	public static int Solve(String[] damageChart, int[] bh) {
		int l = bh.length;
		boolean visited[] = new boolean[1 << (l + 1)];
		int best, damage, sh;
		TreeSet<node> pq = new TreeSet<node>();
		pq.add(new node(1 << l, 0));
		while (!pq.isEmpty()) {
			node n = pq.pollFirst();
			if (visited[n.weapon])
				continue;
			if (n.weapon == ((1 << (l + 1)) - 1))
				return n.shots;
			visited[n.weapon] = true;

			for (int i = 0; i < l; i++) {
				if ((n.weapon & (1 << i)) == 1)
					continue;

				best = bh[i];
				ytre: for (int j = 0; j < l; j++) {
					if ((n.weapon & 1 << j) == 0)
						continue ytre;

					damage = Integer.parseInt(damageChart[j]
							.substring(i, i + 1));
					if (damage == 0 || i == j)
						continue ytre;

					sh = bh[i] / damage;
					if (bh[i] % damage != 0)
						sh++;
					if (sh < best)
						best = sh;

				}
				int config = n.weapon | 1 << i;
				pq.add(new node(config, n.shots + best));

			}
		}

		return -1;
	}

	boolean ddd = false;

	static int[] s2ia(String s) {
		int[] r = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			r[i] = s.charAt(i) - '0';
		}
		return r;
	}

	public static int leastShots(String[] damageChart, int[] bossHealth) {
		int i, j, k;
		int n = damageChart.length;
		int[][] dc = new int[n][];
		int[] cost = new int[1 << n];
		for (i = 0; i < n; i++) {
			dc[i] = s2ia(damageChart[i]);
		}
		for (i = 1; i < 1 << n; i++) {
			cost[i] = 65536 * 30000;
			for (j = 0; j < n; j++) {
				int pre = i - (1 << j);
				if ((i & (1 << j)) != 0) {
					cost[i] = Math.min(cost[i], cost[pre] + bossHealth[j]);
					for (k = 0; k < n; k++) {
						if ((i & (1 << k)) != 0 && k != j && dc[k][j] > 0) {
							cost[i] = Math
									.min(cost[i], cost[pre]
											+ (bossHealth[j] + dc[k][j] - 1)
											/ dc[k][j]);
						}
					}
				}
			}
		}
		return cost[(1 << n) - 1];
	}

	public static void main(String args[]) {
		String[] a = { "198573618294842", "159819849819205", "698849290010992",
				"000000000000000", "139581938009384", "158919111891911",
				"182731827381787", "135788359198718", "187587819218927",
				"185783759199192", "857819038188122", "897387187472737",
				"159938981818247", "128974182773177", "135885818282838" };
		int b[] = { 157, 1984, 577, 3001, 2003, 2984, 5988, 190003, 9000,
				102930, 5938, 1000000, 1000000, 5892, 38 };
		long now = (System.nanoTime());
		System.out.println(Solve(a, b));
		long elapsed = (System.nanoTime() - now);
		System.out.println(elapsed);
		System.out.println("ori : " + Integer.toBinaryString(Integer.MIN_VALUE));
		for (int i = 1; i < 1 << 5; i++) {

			for (int j = 0; j < 5; j++) {
				int pre = i - (1 << j);
				System.out.println(pre + " "+Integer.toBinaryString(pre));
			}
		}
	}
}

