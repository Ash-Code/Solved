package CodeProbs;

import java.io.IOException;

public class AutoLoan {

	public static boolean predicate(double max, int term, double monthly,
			double price) {
		int c = 0;
		double rate = max / 1200;
		double bal = price;
		while (c < term) {
			bal = ((bal + (bal * rate)) - monthly);
			c++;
		}
		if (bal > 0) {
			return false;
		} else
			return true;

	}

	public static double interestRate(double price, double monthlyPayment,
			int loanTerm) {

		double lo = 0;
		double hi =100;
		while (hi-lo>1e-9) {
			double x = lo + (hi - lo) / 2;
			
			if (predicate(x, loanTerm, monthlyPayment, price)) {
				lo = x;
			} else
				hi = x;

		
		}

		return hi;
	}

	public static void main(String[] args) throws IOException {

		int a = 10;
		int b = -17;
System.out.println(interestRate(2000,510,4));
	}
	
}
