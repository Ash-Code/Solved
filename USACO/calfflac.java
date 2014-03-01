

/*
 ID: renegad2
 LANG: JAVA
 TASK: calfflac
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class calfflac {

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"calfflac.out")));
		String in = "", temp = "", S = "";
		temp = bf.readLine();
		
	StringBuilder sb=new StringBuilder();
		
		while (temp != null) {
			sb.append(temp).append("\n");
			temp = bf.readLine();

		}
	in=sb.toString();
	sb=null;
	sb=new StringBuilder();
		ArrayList<Integer> pos = new ArrayList<Integer>();
		for (int i = 0; i < in.length(); i++) {
			if ((((int) in.charAt(i) <= 122) && (int) in.charAt(i) >= 97)
					|| ((int) in.charAt(i) <= 90 && in.charAt(i) >= 65)) {
				if (((int) in.charAt(i) <= 90 && in.charAt(i) >= 65)) {
					sb.append((char) (32 + (int) in.charAt(i)));
				} else {
					sb.append(in.charAt(i));
				}
				pos.add(i);
			}
			

		}
		S=sb.toString();
		int max = 0, l = 0, left = 0, right = 0, posl = 0, posr = 0, push = 0;
		for (int i = 0; i < S.length(); i++) {

			left = right = i;

			while (left >= 0 && right < S.length() && S.charAt(left)==S.charAt(right)) {
				--left;
				++right;
			}

			l = right - left - 1;
			if (l > max) {
				max = l;
				posl = left + 1;
				posr = right - 1;
			}
			left = i;
			right = i + 1;
			while (left >= 0 && right < S.length() && S.charAt(left)==S.charAt(right)) {
				--left;
				++right;
			}

			l = right - left - 1;
			if (l > max) {
				max = l;
				posl = left + 1;
				posr = right - 1;
			}

		}


		if (pos.isEmpty()) {
			pw.println(0);
			pw.println("");
		} else {
			pw.println(max);
			pw.println(in.substring(pos.get(posl), pos.get(posr) + 1));
		}
		pw.close();
		System.exit(0);
	}
}
