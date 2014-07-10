package DS;

import DS.Link;

public class LinkedList<T> {
	Link head;
	Link tail;// there is no O(1) remove operation for LinkedLists. Its possible
				// only if the pointer to the link/node is provided, which
				// cannot be accessed since it is defined and produced by the
				// linkedList itself. So for every node to delete, we iterate
				// through the list till we find the required object, get it's
				// node's pointer and unlink it (see Sun's java code)

	public void add(T elm) {
		Link link = new Link(elm);
		if (tail == null) {
			tail = link;
			head = link;
		}
		tail.next = link;
		tail.next.prev=tail;
		tail = link;

	}

	public void removeFirst(T elm) {
		if (head == null)
			throw new ArrayIndexOutOfBoundsException();
		else
			head = head.next;

	}

	public T search(T elm) {
		Link temp = head;
		while (temp != null) {
			if (temp.object == elm)
				return (T) temp.object;

			temp = temp.next;

		}
		return null;
	}
	
	

}
