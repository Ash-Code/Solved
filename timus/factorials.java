package CodeProbs;

import java.io.IOException;
import java.util.Scanner;

public class factorials {
	public static String Solve(int a) {
	if(1<=a&& a<=4)
		return "few";
	if(5<=a&& a<=9)
		return "several";
	if(10<=a&& a<=19)
		return "pack";
	if(20<=a&& a<=49)
		return "lots";
	if(50<=a&& a<=99)
		return "horde";
	if(100<=a&& a<=249)
		return "throng";
	if(250<=a&& a<=499)
		return "swarm";
	if(500<=a&& a<=999)
		return "zounds";
	else
		return "legion";

	}

	public static void main(String args[]) throws IOException {

		Scanner s= new Scanner(System.in);
		
		System.out.println(Solve(s.nextInt()));
	}

}
