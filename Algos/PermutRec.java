package Algos;

public class PermutRec {

	public static String perm2(String prefix, String s){
		
		int N=s.length();
		if(N==1){
			return s;
		}
		String res="";
		for(int i=0;i<N;i++){
			res=perm2(prefix+s.charAt(i), s.substring(0,i)+s.substring(i+1));
		}
		return res;
	}
	
	public static void swap(char[] ch, int i, int j) {

		char t = ch[i];
		ch[i] = ch[j];
		ch[j] = t;

	}// Instead of incrementing startPos in each iteration of the loop, just
		// pass its increment to the recursive call. What this code does is the
		// following: If startPos is smaller than the length of the string, swap
		// the character at startPos with each character after and including
		// that position, and do the recursive call for the next starting
		// position. Since all this happens in-place, i.e., without creating a
		// new StringBuffer in each iteration, we have to swap the characters
		// back after the recursive call, to restore the original ordering of
		// the string. Finally, when startPos equals the length of the string
		// (the "leafs" in the recursion tree), the permutation is printed.

	static void doPermutation(char[] permStr, int startPos) {
		if (startPos < permStr.length) {
			for (int i = startPos; i < permStr.length; i++) {
				swap(permStr, startPos, i);
				doPermutation(permStr, startPos + 1);
				swap(permStr, startPos, i);
			}
		} else {
			System.out.print("\"");
			System.out.print(permStr);
			System.out.print("\", ");
		}
	}

	public static void main(String[] args) {
		String s = new String("123");
		doPermutation(s.toCharArray(), 0);

	}

}
