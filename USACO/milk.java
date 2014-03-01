

/*
 ID: renegad2
 LANG: JAVA
 TASK: milk
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class milk {


	

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader("milk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk.out")));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] price= new int[M];
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		StreamTokenizer s = new StreamTokenizer(bf);
		for (int i = 0; i < M; i++) {
			s.nextToken();
			int a = (int) s.nval;
			s.nextToken();
			int b = (int) s.nval;
			price[i]=a;
if (map.containsKey(a)) {
				map.put(a, map.get(a)+ b);
			} else
				map.put(a, b);
			
		}
		Arrays.sort(price);
		int Tmilk=0, cost=0, i=0, diff=0, last=-1;
		while(Tmilk<N){
if(price[i]==last){
i++;
continue;
}
			diff=N-Tmilk;
			Tmilk+=Math.min(map.get(price[i]),diff);
			cost+=price[i]*(Math.min(diff, map.get(price[i])));
last=price[i];			
i++;
		}
		pw.println(cost);
	
		pw.close();
		System.exit(0);
	}
}
