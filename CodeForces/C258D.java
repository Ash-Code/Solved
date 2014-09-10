package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C258D {

	static int odd = 0, even = 0;

	public static void pals(int pivot, char[] line, ArrayList<Integer> list) {
		int sum = 0;
		for (int i = pivot, j = pivot; i >= 0 && j < line.length; i--, j++) {
			int length = j - i + 1;
			sum = 0;
			if (line[i] == line[j]) {
				if (i != j)
					sum += (list.get(i) + list.get(j));
				else
					sum += list.get(i);
			} else {
				break;
			}
			int diff = sum - length + 1;
			odd++;
			if (diff > 0) {
				odd += diff / 2;
				even += diff / 2;
				if (diff % 2 == 0)
					even++;
			}

		}

	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = bf.readLine();
		char[] line = in.toCharArray();
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		char prev = line[0];
		int count = 0;
		for (char x : line) {
			if (x != prev) {
				list.add(count);
				count = 0;
				sb.append(prev);
				prev = x;
				count++;
			} else {
				count++;
			}
		}
		list.add(count);
		sb.append(line[line.length - 1]);

		System.out.println(sb.toString());
		System.out.println(list);
		line = sb.toString().toCharArray();
		for (int i = 0; i < line.length; i++) {
			pals(i, line, list);
		}

		System.out.println(even + " " + odd);

	}

}
