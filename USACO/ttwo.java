package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 ID: renegad2
 LANG: JAVA
 TASK: runaround
 */
public class ttwo {
	public static PrintWriter pw;

	public static class node {
		int x, y, dir;

		public node(int a, int b) {
			x = a;
			y = b;
			dir = 0;
		}

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static boolean map[][];

	public static void move(node a) {//*****BETTER WAY!!!**

		int nx = a.x + dx[a.dir];
		int ny = a.y + dy[a.dir];
		if (nx < 10 && nx >= 0 && ny < 10 && ny >= 0 && !map[nx][ny]) {

			a.x = nx;
			a.y = ny;

		} else {
			a.dir++;
			a.dir %= 4;
		}
	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		String in[] = new String[10];
		for (int i = 0; i < 10; i++) {
			in[i] = bf.readLine();
		}
		map = new boolean[10][10];
		node F = new node(0, 0), C = new node(0, 0);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (in[i].charAt(j) == '*')
					map[i][j] = true;
				if (in[i].charAt(j) == 'F') {
					F = new node(i, j);
				}
				if (in[i].charAt(j) == 'C') {
					C = new node(i, j);
				}

			}
		}

		int dir = 0, dirC = 0;
		// BEST WAY TO SIMULATE MOTION IS TO USE A DX/DY ARRAY CORRESPONDING TO
		// EACH DIRECTION.
		int count = 0;
		boolean flag = false;
		
		for(int i=0;i<=160000;i++){
			move(F);
			move(C);
			if(F.x==C.x&&F.y==C.y){
				System.out.println((i+1));
				flag=true;
				break;
			}
				
		}
		
		while (count >= 10000) {

			pw.println(F.x + " " + F.y + " " + C.x + " " + C.y + " " + count);
			if (dir == 0) {
				if (F.x == 0 || map[F.x - 1][F.y]) {
					dir++;
					dir %= 4;

				} else {
					F.x--;

				}
			} else if (dir == 1) {
				if (F.y == 9 || map[F.x][F.y + 1]) {
					dir++;
					dir %= 4;

				} else {
					F.y++;

				}
			} else if (dir == 2) {
				if (F.x == 9 || map[F.x + 1][F.y]) {
					dir++;
					dir %= 4;

				} else {
					F.x++;

				}

			} else if (dir == 3) {
				if (F.y == 0 || map[F.x][F.y - 1]) {
					dir++;
					dir %= 4;

				} else {
					F.y--;

				}
			}

			if (dirC == 0) {
				if (C.x == 0 || map[C.x - 1][C.y]) {
					dirC++;
					dirC %= 4;

				} else {
					C.x--;

				}
			} else if (dirC == 1) {
				if (C.y == 9 || map[C.x][C.y + 1]) {
					dirC++;
					dirC %= 4;

				} else {
					C.y++;

				}
			} else if (dirC == 2) {
				if (C.x == 9 || map[C.x + 1][C.y]) {
					dirC++;
					dirC %= 4;

				} else {
					C.x++;

				}

			} else if (dirC == 3) {
				if (C.y == 0 || map[C.x][C.y - 1]) {
					dirC++;
					dirC %= 4;

				} else {
					C.y--;

				}
			}

			count++;
			if (F.x == C.x && F.y == C.y) {
				pw.println(count);
				flag = true;
				break;
			}

		}
		if (!flag)
			pw.println("0");

		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
