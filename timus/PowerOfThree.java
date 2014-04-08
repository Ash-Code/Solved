package CodeProbs;

import java.io.IOException;
import java.util.LinkedList;

public class PowerOfThree {

	public static String Proper(int x, int y){
		
		while(x!=0||y!=0){
			int dx=x%3;
			int dy=y%3;
			if((dx+dy)!=1)
				return "Impossible";
			x/=3;
			y/=3;
		}
		
		return "Possible";
		
	}
	public static String Solve(int x, int y) {
		if(x==0||y==0){
			return "Impossible";
		}
		double temp = (Math.log(Math.max(x, y)) / Math.log(3));
		int shift = (int) Math.ceil(temp) + 1;
		System.out.println(temp);
		int X = 0, Y = 0;
		ytre: for (int i = 1 << shift; i <= ((1 << (shift + 1)) - 1); i++) {
			System.out.println(X + "  " + Y);
			X = 0;
			Y = 0;
			System.out.println(Integer.toBinaryString(i));
			for (int j = 0; j < shift; j++) {
				if (X > x && y > y) {
					continue ytre;
				}
				if ((i&1<<j )== 1<<j) {
					X += Math.pow(3, j);
				} 
				else 
					Y += Math.pow(3, j);
			}
			
			if (X == x && Y == y) {
				System.out.println(Integer.toBinaryString(i));
				return "Possible";
			}
		}
		return "Impossible";
	}

	public static void main(String[] args) throws IOException {
		String a = "AABACCCCABAA";
		System.out.println(Proper(1093,2187));

	}
}
