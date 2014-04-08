package CodeProbs;

public class Poetry {

	public static String[] conv(String[] poem) {
		int size = poem.length;
		String temp = "";
		String word[] = new String[size];
		
		there: for (int i = 0; i < size; i++) {
			temp = poem[i].trim();
			if (temp.length() == 0) {
				word[i] = " ";
				continue there;
			}
			
			for (int j = temp.length(); j > 0; j--) {
				
				if (temp.substring(j - 1, j).equals(" "))
					word[i] = temp.substring(j - 1, j);
				if (j == 1)
					word[i] = temp;
			}
		}
		return word;
	}

	public static boolean vowel(String a, String word, int j) {
		if (a.equalsIgnoreCase("y")) {
			if ((j == word.length() - 1) || j == 0) {
				return false;
			} else
				return true;
		}

		if (a.equalsIgnoreCase("a") || a.equalsIgnoreCase("e")
				|| a.equalsIgnoreCase("i") || a.equalsIgnoreCase("o")
				|| a.equalsIgnoreCase("u"))
			return true;
		return false;
	}

	public static String rhymeScheme(String[] poem) {
		int size = poem.length, ascii=(int)'a'-1, tag = 0;
		String words[] = conv(poem), temp = "", result = "", pnew = "", plast = "", scheme="";

		ytre:for (int i = 0; i < size; i++) {
			if(words[i].equals(" ")){
				result+=" ";
			continue ytre;
			}
			
			for (int j = words[i].length(); j > 0 && tag == 0; j--) {
				if (vowel(words[i].substring(j - 1, j), words[i], j - 1)) {
					pnew = words[i].substring(j - 1);
				}
				if (pnew.length() > 0) {
					if ((!vowel(words[i].substring(j - 1, j), words[i], j - 1)))
						tag = 1;
				}

			}
			
			
			if(!pnew.equals(plast)){
				ascii++;
			}
			scheme = Character.toString((char)(ascii>122?ascii-58:ascii));
			result+=scheme;
			plast = pnew;
			tag=0;
			pnew="";
			

		}
		return result;
		
	}
	
	
	public static void main(String args[]){
		String[] poems = { "This poem has uppercase letters",
				"In its rhyme scheme", "Alpha", "Blaster", "Cat", "Desert",
				"Elephant", "Frog", "Gulch", "Horse", "Ireland", "Jam",
				"Krispy Kreme", "Loofah", "Moo", "Narf", "Old", "Pink",
				"Quash", "Rainbow", "Star", "Tour", "Uvula", "Very", "Will",
				"Xmas", "Young", "Zed", "deception", "comic", "grout", "oval",
				"cable", "rob", "steal", "steel", "weak" };
		System.out.println(rhymeScheme(poems));
		
		
	}

}