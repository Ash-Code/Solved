package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.TreeSet;

/*
ID: renegad2
LANG: JAVA
TASK: frac1
*/

public class frac1 {
	
		
		public static class node implements Comparable<node>{
			int n, d;
			double val;
			public node(int n, int d){
				this.n=n;
				this.d=d;
				val=(double)n/(double)(d);
			}
			@Override
			public int compareTo(node x){
				if(x.val>val)
					return -1;
				if(x.val<val)
					return 1;
				return 0;
			}
		}
		public static void main(String args[]) throws IOException {
			long time = System.currentTimeMillis();
			BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					"C:/ride.out")));
			StreamTokenizer st = new StreamTokenizer(bf);
			st.nextToken();
			int N=(int)st.nval;
			TreeSet<node> set=new TreeSet<node>();
			double n=N;
			for(int i=1;i<=N;i++){
				
				for(int j=0;j<=i;j++){
					set.add(new node(j,i));
				}
					
			}
			
			while(!set.isEmpty()){
				node x=set.pollFirst();
				pw.println(x.n+"/"+x.d);
			}
			

			pw.close();
			

			System.out.println(System.currentTimeMillis() - time);
			System.exit(0);

		}
	}

