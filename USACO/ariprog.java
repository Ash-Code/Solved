// USACO ANALYSIS
//Rather than doing a Binary Search everytime to check a numbers presence,
// take a boolean array of the size of the max value. Mark it true everywhere the 
// numbers appear, and just check if the number is true or false in the array.
// this can also be used while creating the array of numbers, i.e. rather than using treeset,
// if already marked, don't add; if not marked, add and mark the array.


// ALSO : Create a sorted non repeating list using treeset. Creating an arrayList and checking everytime for repititive values is VERY time- consuming  


/*
 ID: renegad2
 LANG: JAVA
 TASK: ariprog
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/*Algo
 * 
 */

public class ariprog {
	
	public static int[] list;
	public static PrintWriter pw;
public static TreeSet<Integer> ll;
public static boolean[] places=new boolean[125001];
	public static class node implements Comparable<node> {
		int start, d;

		public node(int start, int d) {
			this.start = start;
			this.d = d;
		}

		@Override
		public int compareTo(node a) {
			if (d > a.d)
				return 1;
			if (d < a.d)
				return -1;
			if (start > a.start)
				return 1;
			if (start < a.start)
				return -1;
			else
				return 0;
		}

	}

	public static void Create(int M) {
		long time = System.currentTimeMillis();
		ll=new TreeSet<Integer>();
		int temp = 0;
		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= M; j++) {
				temp = i * i + j * j;
				if(!places[temp]){
				ll.add(temp);
				places[temp]=true;
				}
			}
		}

		System.out.println(System.currentTimeMillis() - time);
		
	}

	public static boolean BS(int s, int e, int t) {
		
		e = Math.min(list.length - 1, e);

		while (s + 1 < e) {
			int mid = s + (e - s) / 2;

			if (list[mid] == t)
				return true;
			if (list[mid] > t)
				e = mid;
			else
				s = mid;
		}
		if (list[s] == t)
			return true;
		if (list[s + 1] == t)
			return true;
		return false;

	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("ariprog.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		Create(M);
		Integer[] lll=ll.toArray(new Integer[0]);
		list=new int[ll.size()];
		for(int i=0;i<ll.size();i++)
			list[i]=(int)lll[i];
		System.out.println(System.currentTimeMillis()-time);
		TreeSet<node> res = new TreeSet<node>();
		boolean found = true;
		int dmax = list[list.length-1] / (N - 1) + 1;
		int d = 0;
		int max = list[list.length-1];
		System.out.println(dmax);

		// Iterative Searching

		for (int i = 0; i < list.length - 1; i++) {
			int first = list[i];

			ytre: for (int j = i + 1; d <= dmax && j < list.length; j++) {
				d = list[j] - first;
				for (int n = 2; n < N; n++) {

					int c = first + n * d;
					
					if (c > max)
						continue ytre;
					found=places[c];
					if (!found)
						continue ytre;

				}

				res.add(new node(first, d));
			}
			d = 0;

		}

		if (res.size() == 0) {
			pw.println("NONE");
		} else {
			for (node n : res) {
				pw.println(n.start + " " + n.d);
			}
		}
		pw.close();
		System.out.println(System.currentTimeMillis() - time);
		System.exit(0);
	}
}
