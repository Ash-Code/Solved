package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

/*
 ID: renegad2
 LANG: JAVA
 TASK: ariprog
 */
public class preface {

	static boolean done[];
	static node list[];

	public static class node {
		int i = 0, v = 0, x = 0, l = 0, c = 0, d = 0, m = 0;

		public void add(node a) {
			i += a.i;
			v += a.v;
			x += a.x;
			l += a.l;
			c += a.c;
			d += a.d;
			m += a.m;
		}
	}

	public static void id(int a) {

		done[a] = true;

		if (a >= 1000) {
			list[a].m = a / 1000;
		}

		if (a < 1000) {
			if (a == 900) {
				list[a].c++;
				list[a].m++;
			} else if (a >= 500) {
				list[a].d++;
				list[a].c = (a / 100) - 5;
			} else if (a == 400) {
				list[a].c++;
				list[a].d++;
			} else if (a < 400 && a >= 100) {
				list[a].c = a / 100;
			} else if (a < 100) {

				if (a == 90) {
					list[a].c++;
					list[a].x++;
				} else if (a >= 50) {
					list[a].l++;
					list[a].x = (a / 10) - 5;
				} else if (a < 50) {
					if (a == 40) {
						list[a].l++;
						list[a].x++;
					} else if (a >= 10) {
						list[a].x = a / 10;
					} else if (a < 10) {

						if (a == 9) {
							list[a].x++;
							list[a].i++;
						} else if (a >= 5) {
							list[a].v++;
							list[a].i = a - 5;
						} else if (a < 5) {
							if (a == 4) {
								list[a].v++;
								list[a].i++;
							} else
								list[a].i = a;
						}

					}
				}

			}

		}

	}

	public static void rec(int a) {
		Stack<Integer> s = new Stack<Integer>();
		int x = a;
		while (x > 0) {
			s.add(x % 10);
			x /= 10;
		}
		int n = s.size() - 1;
		for (int i = n; i >= 0; i--) {
			int d = s.pop();
			d *= Math.pow(10, i);
			
			if (!done[d]) {
				id(d);
				break;
			}
			list[a].add(list[d]);
		}
		done[a] = true;

	}

	/*
	 * if number found return else : extract the first numbers*its place get the
	 * next big number check next big-dec if true assign or add.
	 */

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"C:/ride.out")));
		int N = Integer.parseInt(bf.readLine());
		done = new boolean[N + 1];
		list = new node[N + 2];
		list[0] = new node();
		done[0] = true;
		list[N+1]=new node();
		for (int i = 1; i <= N; i++) {
			
			list[i] = new node();
			rec(i);
			list[N+1].add(list[i]);
			
		}
		int i=N+1;
		if(list[N+1].i>0)
			pw.println("I "+list[N+1].i);

		if(list[N+1].v>0)
			pw.println("V "+list[N+1].v);

		if(list[N+1].x>0)
			pw.println("X "+list[N+1].x);

		if(list[N+1].l>0)
			pw.println("L "+list[N+1].l);

		if(list[N+1].c>0)
			pw.println("C "+list[N+1].c);

		if(list[N+1].d>0)
			pw.println("D "+list[N+1].d);

		if(list[N+1].m>0)
			pw.println("M "+list[N+1].m);
		System.out.println(System.currentTimeMillis()-time);
		pw.close();

	}

}
