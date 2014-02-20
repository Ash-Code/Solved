package CodeProbs;

import java.util.TreeSet;

public class BombMan {
	public static class Node implements Comparable<Node> {

		int x, y;
		int cost = 200000;
		int bombs = 0;

		public Node(int x, int y, int cost, int bombs) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.bombs = bombs;
		}

		@Override
		public int compareTo(Node n) {
			if (n.cost > cost)
				return -1;
			if (n.cost < cost)
				return 1;
			if (n.bombs > bombs)
				return 1;
			if (n.bombs < bombs)
				return -1;
			if (this.x > n.x || this.y > n.y)
				return 1;
			if (this.x < n.x || this.y < n.y)
				return -1;
			else
				return 0;
		}
	}

	public static int[] finder(String[] maze) {
		int pos[] = new int[4];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length(); j++) {
				if (maze[i].substring(j, j + 1).equals("B")) {
					pos[0] = i;
					pos[1] = j;
				}
				if (maze[i].substring(j, j + 1).equals("E")) {
					pos[2] = i;
					pos[3] = j;
				}

			}
		}

		return pos;
	}

	public static int[][] convert(String[] maze) {
		int[][] grid = new int[maze.length][maze[0].length()];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length(); j++) {
				if (maze[i].substring(j, j + 1).equals("."))
					grid[i][j] = 1;
				if (maze[i].substring(j, j + 1).equals("#"))
					grid[i][j] = 3;
				if (maze[i].substring(j, j + 1).equals("E"))
					grid[i][j] = 1;

			}
		}
		return grid;
	}

	public static int shortestPath(String[] maze, int bombs) {

		int rows = maze.length, cols = maze[0].length(), pos[] = finder(maze), w[][], bombsleft=bombs;
		boolean visited[][] = new boolean[maze.length][maze[0].length()];
		int[][] minCost = new int[maze.length][maze[0].length()];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length(); j++) {
				minCost[i][j] = 200000;
			}
		}

		TreeSet<Node> pq = new TreeSet<Node>();
		Node start = null, top = null;
		start = new Node(pos[0], pos[1], 0, bombs);
		System.out.println(start.bombs);
		w = convert(maze);

		pq.add(start);
		while (!pq.isEmpty()) {
			top = pq.pollFirst();
			visited[top.x][top.y] = true;
			System.out.println("Bombs top x "+top.x+ " y "+top.y +" Bombs "+ top.bombs);
			if (top.x == pos[2] && top.y == pos[3])
				return minCost[top.x][top.y];

			if (top.y > 0) {
				bombsleft = top.bombs;
				if (minCost[top.x][top.y - 1] > top.cost + w[top.x][top.y - 1]) {
					if (w[top.x][top.y - 1] == 3 && top.bombs > 0) {
						
						pq.remove(new Node(top.x, top.y - 1,
								minCost[top.x][top.y - 1], top.bombs));
						
						bombsleft--;
						
						minCost[top.x][top.y - 1] = top.cost
								+ w[top.x][top.y - 1];
						pq.add(new Node(top.x, top.y - 1,
								minCost[top.x][top.y - 1], bombsleft));
					} if(w[top.x][top.y-1]==1) {
						pq.remove(new Node(top.x, top.y - 1,
								minCost[top.x][top.y - 1], bombs));

						
						minCost[top.x][top.y - 1] = top.cost
								+ w[top.x][top.y - 1];
						pq.add(new Node(top.x, top.y - 1,
								minCost[top.x][top.y - 1], top.bombs));
					}
				}
			}

			if (top.x < rows - 1) {
				bombsleft = top.bombs;
				if (minCost[top.x + 1][top.y] > top.cost + w[top.x + 1][top.y]) {
					if (w[top.x + 1][top.y] == 3 && top.bombs > 0) {
						
						pq.remove(new Node(top.x + 1, top.y,
								minCost[top.x + 1][top.y], bombs));

						bombsleft--;
						minCost[top.x + 1][top.y] = top.cost
								+ w[top.x + 1][top.y];
						pq.add(new Node(top.x + 1, top.y,
								minCost[top.x + 1][top.y], bombsleft));
					} if(w[top.x + 1][top.y]==1) {

						pq.remove(new Node(top.x + 1, top.y,
								minCost[top.x + 1][top.y], bombs));

						minCost[top.x + 1][top.y] = top.cost
								+ w[top.x + 1][top.y];
						pq.add(new Node(top.x + 1, top.y,
								minCost[top.x + 1][top.y], top.bombs));
					}

				}
			}

			if (top.y < cols - 1) {
				bombsleft = top.bombs;
				if (minCost[top.x][top.y + 1] > top.cost + w[top.x][top.y + 1]) {
					if (w[top.x][top.y + 1] == 3 && top.bombs > 0) {
						
						pq.remove(new Node(top.x, top.y + 1,
								minCost[top.x][top.y + 1], bombs));
						minCost[top.x][top.y + 1] = top.cost
								+ w[top.x][top.y + 1];
						bombsleft--;
						pq.add(new Node(top.x, top.y + 1,
								minCost[top.x][top.y + 1], bombsleft));
					} if(w[top.x][top.y + 1]==1) {
						pq.remove(new Node(top.x, top.y + 1,
								minCost[top.x][top.y + 1], bombs));
						minCost[top.x][top.y + 1] = top.cost
								+ w[top.x][top.y + 1];

						pq.add(new Node(top.x, top.y + 1,
								minCost[top.x][top.y + 1], top.bombs));
					}

				}
			}

			if (top.x > 0) {
				bombsleft = top.bombs;
				if (minCost[top.x - 1][top.y] > top.cost + w[top.x - 1][top.y]) {
					if (w[top.x - 1][top.y] == 3 && top.bombs > 0) {
						
						pq.remove(new Node(top.x - 1, top.y,
								minCost[top.x - 1][top.y], bombs));
						bombsleft--;
						minCost[top.x - 1][top.y] = top.cost
								+ w[top.x - 1][top.y];
						pq.add(new Node(top.x - 1, top.y,
								minCost[top.x - 1][top.y], bombsleft));
					} if(w[top.x - 1][top.y]==1) {
						pq.remove(new Node(top.x - 1, top.y,
								minCost[top.x - 1][top.y], bombs));

						minCost[top.x - 1][top.y] = top.cost
								+ w[top.x - 1][top.y];
						pq.add(new Node(top.x - 1, top.y,
								minCost[top.x - 1][top.y], top.bombs));
					}
				}
			}

		}

		return -1;
	}

	public static void main(String args[]) {
		String maze[] ={".#..#......#..##.#...#..####......#.#...#.#...#..#", "..#...#..##..##...#.....##..##.#....##..##....#..#", ".#..##..##.......#...#..........##...####......###", "..###.##..#.....##..###...####.#....#..##...#.#...", "###.#.#.#..#........#.....#..#.#.#.#....#..#..#.#.", "#.#.##...####.###...#####.#.#.#..###.......#..##.#", "##.........#.##..##.#.###..##..#.#...#.##....###..", "###.###.#.##...####.##.#.#.###...#..#.###..#.#..##", "...#..#...#.#.###..#...###.#.####.#.###.#...##.#.#", "..........###...#.###.....#.##.##...#.#....#...#.#", "#..#.#.#.##.##.##.....##.###.##.#.##.###...####..#", "..#..#...#....#.##.#.##..##..#...##...#..#######..", "#.#...#.#..#....#..#####..#.##..#..##.#..#####...#", ".........#.###.##.#.##...#...#..##...#....##..#.##", "#...###...#......#.#.###..##..#.#####.####.##...##", "..###.##.#....###..........#.#.##....##..#.###...#", "#..###...##.##..###..#...#######....#.#..#...###..", "#.#####..###...#.##..#.#.#.###......#.###.#.#.#...", "...#..#.###.###..###.##..#.#..##...###..#.#..#..#.", "#.##.#......##...#.#.....##.##.#####..##.##..#.##.", "#.#.#..#.###..#...#...#..#....#...###......##..#..", "##.#.##.#..##..#..###..#..#####...#..###.#.#.#..#.", "#####...#.#...#.#.......##.##.#..#.#.##.#..##...#.", ".#.##.#.##..####..##...........#.###..#####.#.#..#", ".###.#.###.##.#.#..#.###..#..##.#.#.##.......##.#.", "##......#.#.#....###.....B.....##..#.###.#..###...", "#.###...##.####...##..###....#.#.##.#.#####....#.#", "..#####..#...##..........#.#.##...###..#.#...#...#", "..##.#...#.#.#.###...#.#..###.#..#..##.#..###...##", "#...##.....#.#....#....#.###.##.####..#..#.##.....", "#..####...#####.##...#..######.#.#.#..#......###..", "..#.#.#...#....#.......#..##.#.##...#.#.#...#..#.#", "###..##.##...##....#..#....#...#..#............#..", "#.######..###.#..#..#..#..#.#.#.#....####.#....#.#", "..####............#.#.#.####.#...##..##.###....#.#", ".#.#....#..#..###........###..##..#.#.#....##..#..", "..#.......##.##...####.#..###..#....#.#.##.......#", "####.#...#....#.##.#..#.#.##.#...###.##..#.#.#.###", "#..##..###.####..##......#....#.....#...###.###.##", ".#.####..##.#.##.##..#..#...##....##.....####.....", "####....######..#......#..#...##.##..####...###.#.", "#.##..##...##..###.#.#....#......###........#...#.", "##...#.#.#.#.#.....###...#####..#..#.##....#.##..#", ".#....###...#.#..##.##..##..##.#.#.#.##.##..##.#.#", "..########.....#..#...#.#.#.###..#..#.####.###..##", "####..#.#...#..#.####...###...####...##..#.#######", "##...#####.###...#......#.#.......#..##....#..#.##", "...##.##..#...##...#....#.##..#.....##...###..##..", "##...#.#.##..##.##........#..#...#..#..#.....##.#.", "E.##.#.###...#.#####.#.####..#..#..#..###..##.##.."}; 
				System.out.println(shortestPath(maze,5));
	}
}
