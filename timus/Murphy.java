package CodeProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Murphy {

	public static String Solve(double l, double h, int w) {
		
		

		double tr, angle, t1 = 0;
		tr = Math.pow(w, -1);
		t1 = (double) Math.sqrt(2 * (h - (l / 2)) / 981);


		angle = (w*t1/60)-Math.floor(w*t1/60);
		
		if ((angle > (0.25)) && (angle < (0.75))) {
			return "bread";
		}

		return "butter";

	}

	public static void input() throws IOException {

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		st.nextToken();
		int l = (int) st.nval;
		st.nextToken();

		int h = (int) st.nval;
		st.nextToken();
		int w = (int) st.nval;

		System.out.println(Solve(l, h, w));
	}

	public static void main(String args[]) throws IOException {

		input();
	}

}
