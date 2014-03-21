package CodingPrac;

import java.util.ArrayList;

public class Heap {
	static ArrayList<Integer> heap;

	public static boolean add(int x) {

		heap.add(x);
		/*
		 * parent>child switch; the child becomes parent index and the new
		 * parent index is new child/2
		 */
		if (heap.size() == 1)
			return true;

		int t, p = heap.size() / 2 - 1, c = heap.size() - 1;
		while (p >= 0 && heap.get(p) > heap.get(c)) {

			t = heap.get(p);
			heap.set(p, heap.get(c));
			heap.set(c, t);
			c = p;
			p = (c + 1) / 2 - 1;

		}
		return false;
	}

	public static boolean remove(int x) {
		int i = 0;
		boolean found;
		while (true) {
			if (heap.get(i) == x) {
				found = true;
				break;
			}
			i++;

		}
		if (found) {
			heap.set(i, heap.remove(heap.size() - 1));

			int t, p = i, c = (i + 1) * 2 - 1;
			while (c < heap.size() && heap.get(p) > heap.get(c)) {

				t = heap.get(p);
				heap.set(p, heap.get(c));
				heap.set(c, t);
				p = c;
				c = (p + 1) * 2 - 1;

			}

			return true;
		}

		return false;

	}

	public static boolean alter(int x, int y) {
		int i = 0;
		boolean found;
		while (true) {
			if (heap.get(i) == x) {
				found = true;
				break;
			}
			i++;

		}

		if (found) {
			heap.set(i, y);

			int t, p = i, c = (i + 1) * 2 - 1;
			while (c < heap.size() && heap.get(p) > heap.get(c)) {

				t = heap.get(p);
				heap.set(p, heap.get(c));
				heap.set(c, t);
				p = c;
				c = (p + 1) * 2 - 1;

			}

			return true;
		}

		return false;

	}

	public static void print() {
		/*
		 * keep an offset:
		 */
		int l = 10, elm = 1;
		int counter = 0, end;
		while (l > 0) {

			for (int i = 0; i < l - elm - 1; i++) {
				System.out.print(" ");
			}
			end=Math.min(counter+elm, heap.size());
			for (int i = counter; i < end; i++) {
				System.out.print(heap.get(i) + " ");
			}
			System.out.println("");
if(end==heap.size())
	break;
			counter+=elm;
			elm*=2;
			l--;		
		}

	}

	public static void main(String args[]) {
		heap = new ArrayList<Integer>();
		add(11);
		add(10);
		add(13);
		add(8);
		add(12);
		add(6);
		add(9);
		add(5);
		add(3);
		remove(3);
		alter(5, 20);
		add(21);
		add(16);
		add(19);
		add(67);
		add(72);
		add(81);
		add(2);
		add(3);
		System.out.println("");
		for (int i = 0; i < heap.size(); i++)
			System.out.print(heap.get(i) + " ");
		System.out.println("");
		print();

	}

}
