package TopCoder;
import java.util.Arrays;

public class HappyLetterDiv2 {

	public char getHappyLetter(String letters) {
		char[] in = letters.toCharArray();
		int[] stacker = new int[26];
		for (int i = 0; i < in.length; i++) {
			stacker[in[i] - 'a']++;
		}
		char happy='.';
		int smax=0;
		for(int i=0;i<stacker.length;i++){
			if(stacker[i]>smax){
				smax=stacker[i];
				happy=(char)(i+'a');
			}
		}
		
		Arrays.sort(stacker);
		int sum = 0;
		for (int i = 0; i < stacker.length - 1; i++) {
			sum += stacker[i];
		}
		if(stacker[stacker.length-1]<=sum){
			happy='.';
		}

		return happy;
	}

}
