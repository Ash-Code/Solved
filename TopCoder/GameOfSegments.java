package TopCoder;

public class GameOfSegments {
	public static int[][] dp;

	public static int rec(int N, int turn) {
		if (dp[N][turn] != 0) {
			//System.out.println("called " + N + " " + turn + " ans "+ dp[N][turn]);
			return dp[N][turn];
		}
		int tt = 0;
		if (turn == 1)
			tt = 2;
		else
			tt = 1;

		int res = tt;
		for (int i = 0; i <= N - 4; i++) {
			int a = i, b = N - 4 - i;
			if (a > 1)
				a++;
			if (b > 1)
				b++;
		//	System.out.println("For : "+N+" "+turn+" seg: a "+a+": "+ (rec(a,tt))+"  b "+ b+": "+(rec(b,tt)));
			if (rec(a, tt) == turn && rec(b, tt) == turn)
				res = turn;
			if (rec(a, tt) ==tt && rec(b, tt) == tt){
				if(a>3||b>3){
					continue;
				}else
					res=turn;
			}
				
			
		}
		dp[N][turn] = res;
		//System.out.println(N + " " + turn + " send: " + tt + " res :" + res);
		return res;
	}

	public static int winner(int N) {
		dp = new int[1010][3];
		for (int i = 1; i <= 2; i++) {
			dp[2][i] = i;
			dp[1][i] = i;
			dp[3][i] = i;
			dp[4][i] = i;
			dp[6][i]=i;
			
		}
		dp[0][1] = 2;
		dp[0][2] = 1;
		rec(N, 1);
		return dp[N][1];
	}

	public static void main(String args[]) {
		//for(int i=3;i<300;i++)
		System.out.println(winner(58));
	}

}
