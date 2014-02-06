

/*
 ID: renegad2
 LANG: JAVA
 TASK: friday
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class friday {

	public static int get(String a) {
		int res = 1;
		for (int i = 0; i < a.length(); i++)
			res *= (a.charAt(i) - 64);

		return res;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("friday.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
		int N = Integer.parseInt(bf.readLine());
		HashMap<Integer, Integer> months = new HashMap<Integer,Integer>();
		months.put(1, 31);
		months.put(2, 28);
		months.put(3, 31);
		months.put(4, 30);
		months.put(5, 31);
		months.put(6, 30);
		months.put(7, 31);
		months.put(8, 31);
		months.put(9, 30);
		months.put(10, 31);
		months.put(11, 30);
		months.put(12, 31);
		HashMap<Integer, Integer> days = new HashMap<Integer,Integer>();
		for (int i = 2; i < 12; i++) {
			months.put(i, months.get(i - 1) + months.get(i));
		}
		for (int i = 0; i < 7; i++)
			days.put(i, 0);
		int first = 1, leap = 0;
		for (int i = 1900; i < 1900 + N; i++) {
			int year = 365;
			leap = 0;
			if ((i % 4 == 0 && i % 100 != 0) || i == 2000) {
				year = 366;
				leap = 1;

			}
			days.put((first + 5)%7, days.get((first + 5)%7) + 1);
			days.put((first + 1)%7, days.get((first + 1)%7) + 1);
			
			for (int j = 3; j <= 12; j++) {
				int day = ((months.get(j - 1) + leap + 13) % 7);
				day = (day + first - 1)%7;
				days.put(day, days.get(day) + 1);
			}
			first = first + (year % 7);
		}
		
		String res="";
		res+=days.get(6);
for(int i=7;i<13;i++){
	res+=(" "+days.get(i%7));
	
}
pw.println(res);
		pw.close();
		System.exit(0);
	}
}
