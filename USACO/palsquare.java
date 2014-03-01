

/*
 ID: renegad2
 LANG: JAVA
 TASK: palsquare
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class palsquare {

	public static String convert(int x, int B){
		String res="",t="";
		char e;
		int temp;
		while(x!=0){
			temp=x%B;
			x/=B;
			if(temp>=10){
				e=((char) ((temp-10)+65));
			}else
				e=((char)(temp+48));
			res+=String.valueOf(e);
		}
		
		for(int i=res.length()-1;i>=0;i--){
			t+=res.charAt(i);
		}
		
		return t;
	}
	public static boolean pal(String a){
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)!=a.charAt((a.length()-1)-i)){
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"palsquare.out")));
		
		int B=Integer.parseInt(bf.readLine());
		int num=1;
		String temp="";
		for(int i=1;i<=300;i++){
			temp=convert(i*i, B);
			
			if(pal(temp)){
				pw.println(convert(i,B)+ " " +temp);
			}
		}
		
		

		pw.close();
		System.exit(0);
	}
}
