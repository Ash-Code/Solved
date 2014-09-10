package TopCoder;
public class CandyMaking {

	public double getDiff(double d, double[] cV, double[] dW) {
		double res = 0;
		for (int i = 0; i < cV.length; i++) {
			res += Math.abs(dW[i] - d * cV[i]);
		}

		return res;
	}

	
	static double[] V, W;
	static int count = 0;


	public double findSuitableDensity(int[] cV, int[] dW) {
		
		int count = 0;
		V = new double[cV.length];
		W = new double[dW.length];
		for (int i = 0; i < cV.length; i++) {
			V[i] = (double) cV[i];
			W[i] = (double) dW[i];

		}
		double ans=Double.MAX_VALUE;
		for(int i=0;i<cV.length;i++){
			double di=W[i]/V[i];
			double temp=getDiff(di,V,W);
			if(temp<ans)
				ans=temp;
			
		}

		return ans;
	}

}
