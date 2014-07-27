package TopCoder;
import java.util.ArrayList;

public class GoodCompanyDivTwo {

	public int countGood(int[] superior, int[] workType) {
		int n = superior.length;
		int count = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> ll = new ArrayList<Integer>();
			ll.add(workType[i]);
			flag=true;
			for (int k = 0; k < n; k++) {
				if (superior[k] == i) {
					if (ll.contains(workType[k]))
						flag = false;
					else
						ll.add(workType[k]);

				}
			}
			if (flag)
				count++;
		}

		return count;
	}

}
