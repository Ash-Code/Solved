package TopCoder;
import java.util.TreeSet;

public class CandidatesSelectionEasy {

	public static class node implements Comparable<node>{
		int pos, skill;
		public node(int a, int b){
		pos=a;
		skill=b;
		}
		@Override
		public int compareTo(node a) {
			// TODO Auto-generated method stub
			if(a.skill<this.skill){
				return -1;
			}
			if(a.skill>this.skill)
				return 1;
			if(a.pos<this.pos)
				return 1;
			if(a.pos>this.pos)
				return -1;
			return 0;
		}
	}
	
	public int[] sort(String[] score, int x) {
		TreeSet<node> list=new TreeSet<node>();
		for(int i=0;i<score.length;i++){
			list.add(new node(i,'A'-score[i].charAt(x)));
		}
		int[] res=new int[score.length];
		int pos=0;
		for(node a:list){
			res[pos]=a.pos;
			pos++;
		}
	
		return res;
	}

}
