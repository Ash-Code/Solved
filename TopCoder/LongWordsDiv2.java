package TopCoder;
public class LongWordsDiv2 {

	public String find(String word) {
	boolean flag=true;
	for(int i=0;i<word.length()-1;i++){
		if(word.charAt(i)==word.charAt(i+1)){
			flag=false;
		}
	}
	String temp="";
	for(int i=0;i<word.length();i++){
		
		for(int j=i+1;j<word.length();j++){
			for(int k=j+1;k<word.length();k++){
				for(int l=k+1;l<word.length();l++){
					if(word.charAt(i)==word.charAt(k)&&word.charAt(j)==word.charAt(l)){
						flag=false;
						break;
					}
				}
			}
		}
		
	}
	
		
		return flag?"Likes":"Dislikes";
	}

}
