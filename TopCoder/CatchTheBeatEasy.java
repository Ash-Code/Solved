package TopCoder;
import java.util.TreeSet;

public class CatchTheBeatEasy {

	public static class pair implements Comparable<pair> {
		int x, y;

		public pair(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(pair l) {
			if (l.y > y)
				return -1;
			if (l.y < y)
				return 1;
			if (l.x > x)
				return -1;
			if (l.x < x)
				return 1;
			else
				return 0;
		}

	}

	public static String ableToCatchAll(int[] x, int[] y) {
		TreeSet<pair> set = new TreeSet<pair>();

		for (int i = 0; i < x.length; i++) {
			set.add(new pair(x[i], y[i]));
		}
		boolean flag=true;
		int pos=0, time=0, cc=0, last=0;
		for(pair t:set){
			cc++;
			int temp=t.y;
			t.y-=time;
			//System.out.println(t.x+" "+temp+" ny: "+t.y+" togo "+Math.abs(t.x-pos)+" el time "+time+" total "+cc);
			if(Math.abs(t.x-pos)>t.y||t.y<0){
				flag=false;
				break;
			}
			
			
			
			time+=t.y;
			pos=t.x;
			last=t.y;
			
		}
	
		return flag?"Able to catch":"Not able to catch";
	}
	public static void main(String args[]){
		int[] x={1,2};
		int[] y={8,8};
	System.out.println(ableToCatchAll(x,y));
	}

}
