package CodeProbs;

import java.util.ArrayList;
import java.util.TreeSet;

public class DungeonEscape {

	public static class Node implements Comparable<Node> {
		int up, down, east, west;
		int x, y;
		int minCost;

		public Node(int up, int down, int east, int west, int x, int y) {
			this.up = up;
			this.down = down;
			this.east = east;
			this.west = west;
			this.x = x;
			this.y = y;
			minCost = 200000;

		}

		@Override
		public int compareTo(Node n) {
			if (minCost > n.minCost)
				return 1;
			if (minCost < n.minCost)
				return -1;
			if (x > n.x)
				return 1;
			if (x < n.x)
				return -1;
			if (y > n.y)
				return 1;
			if (y < n.y)
				return -1;

			else
				return 0;
		}
	}

	public static Node[][] gridMaker(String[] up, String[] down, String[] east,
			String[] west) {

		int u, d, e, w;
		int rows = up.length, cols = up[0].length();
		Node[][] grid = new Node[rows + 1][cols];
		for (int i = 0; i < rows + 1; i++) {
			ytre: for (int j = 0; j < cols; j++) {
				if (i == 0) {
					grid[i][j] = new Node(0, 0, 0, 0, i, j);

					continue ytre;
				}
				if (up[i-1].substring(j, j + 1).equals("x"))
					u = 5000;
				else
					u = Integer.parseInt(up[i-1].substring(j, j + 1));
				if (down[i-1].substring(j, j + 1).equals("x"))
					d = 5000;
				else
					d = Integer.parseInt(down[i-1].substring(j, j + 1));
				if (east[i-1].substring(j, j + 1).equals("x"))
					e = 5000;
				else
					e = Integer.parseInt(east[i-1].substring(j, j + 1));
				if (west[i-1].substring(j, j + 1).equals("x"))
					w = 5000;
				else
					w = Integer.parseInt(west[i-1].substring(j, j + 1));

				grid[i][j] = new Node(u, d, e, w, i, j);
			}
		}

		return grid;

	}

	public static int water(int row) {
		if (row == 3)
			return 1;
		if (row == 2)
			return 2;
		if (row == 1)
			return 3;
		else
			return 3000;
	}

	public static int exitTime(String[] up, String[] down, String[] east,
			String[] west, int startLevel, int startEasting) {
		int rows = up.length + 1, cols = up[0].length(), tfare = 0, ans;
		Node[][] grid = gridMaker(up, down, east, west);
		TreeSet<Node> pq = new TreeSet<Node>();
		grid[startLevel + 1][startEasting].minCost = 0;
		pq.add(grid[startLevel + 1][startEasting]);
		Node top = null;
		ArrayList<Node> sol = new ArrayList<Node>();
		sol.clear();

		while (!pq.isEmpty()) {
			top = pq.pollFirst();
System.out.println(" top's x: " +top.x+" top.y :"+top.y+" mintime : "+ top.minCost);
			if (top.x == 0)
				sol.add(top);

			if ((top.y < cols - 1) && grid[top.x][top.y].east != 5000) {
				tfare = top.minCost + grid[top.x][top.y].east;
				if (grid[top.x][top.y + 1].minCost > tfare
						&& tfare < (water(top.x) * cols)) {
					grid[top.x][top.y + 1].minCost = tfare;
					pq.add(grid[top.x][top.y + 1]);

				}

			}
			if (top.y > 0 && grid[top.x][top.y].west != 5000) {
				tfare = top.minCost + grid[top.x][top.y].west;
				if (grid[top.x][top.y - 1].minCost > tfare
						&& tfare < (water(top.x) * cols)) {
					grid[top.x][top.y - 1].minCost = tfare;
					pq.add(grid[top.x][top.y - 1]);

				}

			}
			if ((top.x > 0) && grid[top.x][top.y].up != 5000) {
				tfare = top.minCost + grid[top.x][top.y].up;
				if (grid[top.x - 1][top.y].minCost > tfare
						&& tfare < (water(top.x - 1) * cols)) {
					grid[top.x - 1][top.y].minCost = tfare;
					pq.add(grid[top.x - 1][top.y]);

				}
			}
			if ((top.x < rows - 1) && grid[top.x][top.y].down != 5000) {
				tfare = top.minCost + grid[top.x][top.y].down;
				if (grid[top.x + 1][top.y].minCost > tfare
						&& tfare < (water(top.x + 1) * cols)) {
					grid[top.x + 1][top.y].minCost = tfare;
					pq.add(grid[top.x + 1][top.y]);

				}

			}

		}
		ans = 20000000;
		for (int i = 0; i < sol.size(); i++) {
			if (ans > sol.get(i).minCost)
				ans = sol.get(i).minCost;

		}
		if (sol.size() != 0)
			return ans;
		return -1;
	}

	public static void main(String args[]){
	String up[] = {"1x2x3x4x5x6x7x8x9",
			 "00000000000000000",
			 "98765432223456789",
			 "12345678987654321"}, down[] ={"00000000000000000",
					 "00000000000000000",
					 "00000000000000000",
					 "00000000000000000"}, east[] = 
						 {"xxxxxxxxxxxxxxxxx",
							 "xxxxxxxxxxxxxxxxx",
							 "22222222222222222",
							 "33333333333333333"},west[]=
								 {"xxxxxxxxxxxxxxxxx",
									 "xxxxxxxxxxxxxxxxx",
									 "22222222222222222",
									 "33333333333333333"};
	
		
		

	System.out.println(exitTime(up, down, east, west, 3,12));
 
	
	
}
}
