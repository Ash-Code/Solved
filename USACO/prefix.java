package USACO;

/* in Stream Tokenizer, a '.' is considered a decimal i.e. numerical value;
 * and wherever streamTokenizer leaves, or exits, that is the place bufferedReader is at and vice versa;
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 ID: renegad2
 LANG: JAVA
 TASK: prefix
 */
public class prefix {
	public static PrintWriter pw;
	static boolean dp[];

	public static int Solve(ArrayList<String> l, String in) {
		dp[0] = true;
		for (int i = 0; i < in.length() + 1; i++) {
			if (dp[i]) {
				for (String t : l) {
					if ((i + t.length() <= in.length())
							&& in.substring(i, i + t.length()).equals(t)) {
						dp[i + t.length()] = true;
					}
				}
			}
		}

		for (int i = in.length(); i >= 0; i--) {
			if (dp[i]) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String args[]) throws IOException {
		long time = System.currentTimeMillis();

		BufferedReader bf = new BufferedReader(new FileReader("C:/ride.in"));
		pw = new PrintWriter(new BufferedWriter(new FileWriter("C:/ride.out")));
		StringTokenizer st;
		ArrayList<String> list = new ArrayList<String>();
		String t = bf.readLine();
		while (!t.equals(".")) {
			st = new StringTokenizer(t);
			while (st.hasMoreElements())
				list.add(st.nextToken());
			t = bf.readLine();
		}

		String in = "";
		t = "";
		StringBuilder sb=new StringBuilder();
		while ((t = bf.readLine()) != null) {
			sb.append(t);
		}
		in=sb.toString();
		dp = new boolean[in.length() + 1];
String[] l=new String[list.size()];
for(int i=0;i<list.size();i++){
	l[i]=list.get(i);
}

		bf.close();
		System.out.println(System.currentTimeMillis()-time);
		System.out.println(Solve(list, in));
		
System.out.println(System.currentTimeMillis()-time);
pw.close();
		System.exit(0);
	}
}
