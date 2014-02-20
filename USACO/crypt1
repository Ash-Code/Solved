

/*
 ID: renegad2
 LANG: JAVA
 TASK: crypt1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class crypt1 {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"crypt1.out")));

		
		int N = Integer.parseInt(bf.readLine());
		if (N == 0) {
			pw.print("0");
		} else {
			ArrayList<Integer> d = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++)
				d.add(Integer.parseInt(st.nextToken()));
			ArrayList<Integer> x = new ArrayList<Integer>();
			TreeSet<Integer> set = new TreeSet<Integer>();
			int top = 0, par1 = 0, par2 = 0, prod = 0, t = 0, temp = 0;

			for (int i = 0; i < d.size(); i++)
				for (int j = 0; j < d.size(); j++)
					for (int k = 0; k < d.size(); k++) {
						top = d.get(k) + d.get(j) * 10 + d.get(i) * 100;
						ytre2: for (int l = 0; l < d.size(); l++)
							ytre: for (int m = 0; m < d.size(); m++) {
								par1 = d.get(m) * top;
								par2 = d.get(l) * top;
								t = par1;
								if (par1 % 1000 != par1) {
									continue ytre;
								}
								while (t > 0) {
									temp = t % 10;
									if (!d.contains(temp))
										continue ytre;
									t /= 10;
								}
								t = par2;
								if (par2 % 1000 != par2) {
									continue ytre2;
								}

								while (t > 0) {
									temp = t % 10;
									if (!d.contains(temp))
										continue ytre2;
									t /= 10;
								}

								prod = par1 + par2 * 10;
								t = prod;
								if (prod % 10000 != prod) {
									continue ytre;
								}

								while (t > 0) {
									temp = t % 10;
									if (!d.contains(temp))
										continue ytre;
									t /= 10;
								}
							

								x.add(prod);
							}

					}

			pw.println(x.size());
		}
		pw.close();
		System.exit(0);
	}
}
