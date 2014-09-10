package timus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class T1004 {
	static final int INF = Integer.MAX_VALUE;
	public TreeSet<Node> pq;

	private static class Node implements Comparable<Node> {
		int id;
		int minDis;
		boolean visited;
		int from;
		int auxDis;

		private Node(int a, int b) {
			id = a;
			minDis = b;
			visited = false;
			from = id;
			auxDis = 0;
		}

		@Override
		public int compareTo(Node x) {
			if (x.minDis > this.minDis)
				return -1;
			if (x.minDis < this.minDis)
				return 1;
			return 0;
		}

	}

	public static Node getMinObject(LinkedList<Node> list) {// O(n) search

		Node res = list.getFirst();
		for (Node x : list) {
			if (x.minDis < res.minDis) {
				res = x;
			}
		}
		return res;
	}

	public static class Wrapper {
		String sol;
		int val;

		public Wrapper(String s, int v) {
			sol = s;
			val = v;
		}
	}

	public static Wrapper dikstra(int start, int dest, int[][] map) {
		int n = map[0].length;
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i, INF);
		}
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(nodes[start]);
		while(!list.isEmpty()){
			Node x=list.pollFirst();
			if(x.visited){
				
			}
		}
		return null;

	}

	public static void main(String args[]) {
		Scanner ss = new Scanner(System.in);
		while (true) {
			int n = ss.nextInt();
			if (n < 0)
				return;
			int m = ss.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(map[i], INF);
			for (int i = 0; i < m; i++) {
				int a = ss.nextInt() - 1;
				int b = ss.nextInt() - 1;
				int c = ss.nextInt();
				map[a][b] = Math.min(map[a][b], c);
				map[b][a] = map[a][b];
			}
			int min = INF;
			String result = "No Solution.";
			for (int i = 0; i < n; i++) {
				Wrapper res = dikstra(i, i, map);
				System.out.println(res.val + " sd : " + i + " path : "
						+ res.sol);
				if (res.val != INF && res.val < min) {
					min = res.val;
					result = res.sol;
				}
			}
			System.out.println(result.trim());

		}

	}
}
