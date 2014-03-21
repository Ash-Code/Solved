package USACO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Polygon {
	static PrintWriter pw;
	static int n, num[];
	static char[] in;

	public static int op(int a, int b, char c) {
		
		if (c == 't')
			return (a) + (b);
		else
			return (a) * (b);

	}

	public static int rec(int s, int e) {
		/*
		 * s%2*N;
		 */
		// base case:
		
		
		
		
		if (e - s == 6 || (n - s + e) == 6) {
		int x= Math.max(rec(s, (s + 4)%n), rec((s + 2)%n, e));
		System.out.println(" 6ER : "+ "from "+s+"-"+e+" res :"+x);
		return x;
		}
		
		
		if (e - s == 4 || (n - s + e) == 4) {

			int y = Math.max(

					op(op(num[s], num[(s + 2) % n], in[(s + 1) % n]),
							num[e], in[(s + 3) % n]),
					op(op(num[e], num[(s + 2) % n], in[(s + 3) % n]),
							num[s], in[(s + 1) % n]));
			

			System.out.println( "E  from "+s+"-"+e+" res :"+y);
			return y;
		}
		
		
		
		int a = num[s];
		int b = num[(s + 2) % n] ;
		int c = rec((s + 4) % n, e);
		int x = Math.max(op(op(a, b, in[(s + 1) % n]), c, in[(s + 3) % n]),
				op(op(b, c, in[(s + 3) % n]), a, in[(s + 1) % n]));

		System.out.println("  from "+s+"-"+e+" res :"+x);
		return x;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				System.out)));
		StreamTokenizer st=new StreamTokenizer(bf);
		st.nextToken();
		int N = (int)st.nval;
		n = 2 * N;
		
		int max = 0, temp = 0;
		
		in = new char[n];
		num=new int[n];
		
		for(int i=0;i<n;i++){
			st.nextToken();
			if(st.ttype==st.TT_NUMBER)
				num[i]=(int)st.nval;
			if(st.ttype==st.TT_WORD)
				in[i]=st.sval.charAt(0);
		}
		
		for(int i=0;i<n-1;i+=2){
			System.out.println(in[i]);
			System.out.println(num[i+1]);
		}
		
		
		for (int i = 0; i < 2 * N; i += 2) {
			temp = rec((i + 1) % n, (i + n - 1) % (n));
			System.out.println("EDGE R : "+ (i/2)+ " RES : "+ temp);
			if (temp > max) {
				max=temp;
			}

		}
		
		System.out.println(max);
	}

}
