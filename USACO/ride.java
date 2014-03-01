package CodingPrac;

/*
 ID: renegad2
 LANG: JAVA
 TASK: ride
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class USACO {

	public static int get(String a) {
		int res = 1;
		for (int i = 0; i < a.length(); i++)
			res *= (a.charAt(i) - 64);

		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));

		String a = bf.readLine(), b = bf.readLine(), res = "STAY";
		if (get(a) % 47 == get(b) % 47)
			res = "GO";

		pw.println(res);
		pw.close();
		System.exit(0);
	}

}
