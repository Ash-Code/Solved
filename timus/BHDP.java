package CodeProbs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class BHDP {
	
	public static int Solve(int H, int K, int[] horses){
		
		
		
		
		
		return 0;
	}

	public static void input() throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new FileReader("C:/text.txt")));

		int H, K, horses[];
		st.nextToken();
		H = (int) st.nval;

		st.nextToken();
		K = (int) st.nval;

		horses = new int[H];
		for (int i = 0; i < H; i++) {
			st.nextToken();
			horses[i] = (int) st.nval;
		}

		System.out.println(Solve(H, K, horses));
	}

	public static void main(String args[]) throws IOException {
		input();

	}

	
	
}
