package TopCoder;
import java.util.LinkedList;

public class ChooseTheBestOne {

	public static int countNumber(int N) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		if (N == 1)
			return 1;
		
		
		int curr = 0;
		for (long t = 1; list.size() > 1; t++) {
			long go = (long) Math.pow(t, 3);
			System.out.println(go+" "+t);
			go--;
			int pos = (int) ((curr + go) % list.size());
			list.remove(pos);
			curr=pos;

		}

		return list.pollFirst();
	}
	
	public static void main(String args[]){
		System.out.println(countNumber(4999));
	}
	

}
