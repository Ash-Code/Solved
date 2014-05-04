package TopCoder;
public class Unique {

	public String removeDuplicates(String S) {
	boolean p[]=new boolean[26];
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<S.length();i++){
		if(!p[S.charAt(i)-'a']){
			sb.append(S.charAt(i));
			p[S.charAt(i)-'a']=true;
		}
	}
		
		
		return sb.toString();
		
	}

}
