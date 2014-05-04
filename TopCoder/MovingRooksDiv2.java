package TopCoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class MovingRooksDiv2 {
	

	  static final String POS = "Possible"; 
	  static final String IMP = "Impossible"; 

	  public static String move2(int[] col1, int[] col2) { 
	    State goal = new State(col2); 
	    String goals = goal.toString(); 

	    Set<String> tried = new HashSet<String>(); 
	    LinkedList<State> pq = new LinkedList<State>(); 
	    State f = new State(col1); 
	    pq.add(f); 
	    tried.add(f.toString()); 
	    while (pq.isEmpty() == false) { 
	      State act = pq.poll(); 
	      if (act.toString().equals(goals)) { 
	        return POS; 
	      } 

	      int[] col = act.col; 
	      for (int i = 0; i < col.length; i++) { 
	        int r1 = i; 
	        int c1 = col[r1]; 
	        for (int j = i + 1; j < col.length; j++) { 
	          int r2 = j; 
	          int c2 = col[r2]; 
	          if (r1 < r2 && c1 > c2) { 
	            // (r1,c1) and (r2,c2) -> (r1,c2) and (r2,c1) 
	            int[] ncol = Arrays.copyOf(col, col.length); 
	            ncol[r1] = c2; 
	            ncol[r2] = c1; 

	            State ns = new State(ncol); 
	            String nss = ns.toString(); 
	            if (tried.contains(nss) == false) { 
	              tried.add(nss); 
	              pq.add(ns); 
	            } 
	          } 
	        } 
	      } 
	    } 
	    return IMP; 
	  } 

	  static class State { 

	    int[] col; 

	    public State(int[] col) { 
	      this.col = Arrays.copyOf(col, col.length); 
	    } 

	    @Override 
	    public String toString() { 
	      return Arrays.toString(col); 
	    } 
	  } 
	
	static boolean flag = false;
	public static int[] res;
	static int count = 0;

	public static void swap(int a, int b, int[] Y) {

		int t = Y[a];
		Y[a] = Y[b];
		Y[b] = t;
	}

	public static boolean check(int[] Y) {
		for (int i = 0; i < Y.length; i++) {
			if (Y[i] != res[i])
				return false;
		}
		return true;
	}

	public static void dfs(int[] Y) {
		count++;
		if (count > 1000000)
			return;
		if (flag)
			return;

		if (check(Y)) {
			flag = true;
			return;
		}

		for (int i = 0; i < Y.length; i++) {
			for (int j = i + 1; j < Y.length; j++) {

				if (Y[i] > Y[j] && Y[j] >= res[i]) {

					swap(i, j, Y);
					dfs(Y);
					swap(i, j, Y);
				}
			}
		}

	}

	public static class node {
		int[] Y;

		public node(int[] X) {
			Y = new int[X.length];
			for (int i = 0; i < X.length; i++)
				Y[i] = X[i];
		}
	}

	public static String move(int[] Y1, int[] Y2) {

		res = Y2;
		Stack<node> s = new Stack<node>();
		s.add(new node(Y1));
		while (!s.isEmpty()) {
			node curr = s.pop();
			if (check(curr.Y)) {
				flag = true;
				break;
			}
			for (int i = 0; i < Y1.length; i++) {
				for (int j = i + 1; j < Y1.length; j++) {
					if (curr.Y[i] > curr.Y[j] && curr.Y[j] >= res[i]) {
						node t = new node(curr.Y);
						swap(i, j, t.Y);
						s.add(t);
					}
				}
			}

		}

		return flag ? "Possible" : "Impossible";
	}

	public static void main(String args[]) {
		int[] x1 = { 6, 7, 5, 4, 3, 2, 1, 0 };
		int[] x2 = { 7, 0, 1, 2, 3, 4, 5, 6 };
		int[] Y1 = new int[] { 3, 1, 2, 0 };
		int[] Y2 = new int[] { 3, 2, 0, 1 };
		System.out.println(move2(x1, x2));
	}
}
