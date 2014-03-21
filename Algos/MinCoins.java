package CodingPrac;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class MinCoins {

	static int coins[], sum;

	public static void Read() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:/text.txt")));
		StreamTokenizer st = new StreamTokenizer(bf);
		int i = 0, n = 0;
		st.nextToken();
		sum = (int) st.nval;
		st.nextToken();
		n = (int) st.nval;
		coins = new int[n];
		st.nextToken();
		while (st.nval != (int) -1) {
			coins[i] = (int) st.nval;
			st.nextToken();
			i++;

		}

		System.out.println(minCoins(sum, n, coins));
	}

	public static int minCoins(int sum, int n, int[] coins) {
		Arrays.sort(coins);
		int Min[], j = 0;
		Min = new int[sum + 1];
		Min[0] = 0;
		for (int x = 1; x < sum + 1; x++) {
			Min[x] = 200000000;

		}

		for (int i = 1; i <= sum; i++) {
			j = 0;

			while (j < n && coins[j] <= i) {

				if (Min[i] > 1 + Min[i - coins[j]]) {
					Min[i] = 1 + Min[i - coins[j]];
				}

				j++;

			}
			System.out.println(" the i : " + i + "Min Coins : " +Min[i]);

		}

		return Min[sum];

	}

	public static void main(String args[]) throws IOException {
		MinCoins.Read();
	}

}
