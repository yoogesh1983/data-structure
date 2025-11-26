package com.yoogesh.data.structure.LinkedList;

class SingleLinkList {

	private Node head;
	private int size;

	class Node {
		private String data;
		private Node next;

		Node(String item) {
			this.data = item;
			this.next = null;
			size++;
		}

		Node(String item, Node temp) { // used when copy the list
			this.data = item;
			this.next = temp;
			size++;
		}
	}

	public void addFirst(String item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addLast(String item) {
		Node newNode = new Node(item);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			temp = null;
		}
	}

	public void insert(int index, String item) {
		Node newNode = new Node(item);

		// if the position is greater than the current size, always insert at last
		if (index > size - 1) {
			Node left = head;
			while (left.next != null) {
				left = left.next;
			}
			left.next = newNode;
			left = null;
			return;
		}

		// if empty list, insert at the front
		if (head == null) {
			head = newNode;
			return;
		}

		// if position is zero, insert at the front
		if (index == 0) {
			newNode.next = head;
			head = newNode;
			return;
		}

		// if position is in the middle,use two pointers since at one point right.next
		// points to null, but you need to insert before that
		Node left = null;
		Node right = head;
		int count = 0;
		while (right.next != null && count < index) {
			left = right;
			right = right.next;
			count++;
		}
		left.next = newNode;
		newNode.next = right;
		left = null;
		right = null;
	}

	public void sortedInsertAsc(String item) {
		Node newNode = new Node(item);
		Node temp = head;

		if (temp == null) {
			head = newNode;
			return;
		}

		if (temp.data.length() > item.length()) {
			newNode.next = head;
			head = newNode;
			return;
		}
		while (temp.next != null && temp.next.data.length() < item.length()) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			head = head.next;
			size--;
		}
	}

	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty");
		} else if (head.next == null) {
			head = null;
			size--;
		} else {
			// we need two pointers here since the right pointer will point to null at one
			// point during an iteration and we want before node at that point
			Node left = head;
			Node right = head.next;
			while (right.next != null) {
				left = left.next;
				right = right.next;
			}
			left.next = null;
			left = null;
			right = null;
			size--;
		}
	}

	// delete a single occurrence
	public void deleteElement(String item) {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is empty");
			return;
		}
		if (temp.data.equals(item)) {
			head = head.next;
			size--;
			return;
		}
		while (temp.next != null) {
			if (temp.next.data.equals(item)) {
				temp.next = temp.next.next;
				size--;
				return;
			}
			temp = temp.next;
		}
	}

	// delete all occurrences
	public void deleteElements(String item) {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is empty");
			return;
		}
		if (temp.data.equals(item)) {
			head = head.next;
			size--;
		}
		while (temp.next != null) {
			if (temp.next.data.equals(item)) {
				temp.next = temp.next.next;
				size--;
			}
			if (temp.next != null) {
				temp = temp.next;
			}
		}
	}

	// remove particular index from a list
	public void deleteElement(int index) {
		if (index > size - 1) {
			System.out.println("Please provide an index from 0 to " + (size - 1));
			return;
		}
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}
		Node left = null;
		Node right = head;
		int count = 0;
		while (right.next != null && count < index) {
			left = right;
			right = right.next;
			count++;
		}
		left.next = right.next;
		size--;
		left = null;
		right = null;
	}

	// this is very very hard, so please look carefully!1
	public void reverse() {
		Node curr = head;
		Node left = null;
		Node right = null;
		while (curr != null) {
			right = curr.next;
			curr.next = left;
			left = curr;
			curr = right;
		}
		head = left;
	}

	// reverse using recursive method
	public void reverseRecursive() {
		head = reverseUtil(head, null);

	}

	private Node reverseUtil(Node left, Node right) {
		Node reverse;
		if (left == null) {
			return null;
		}
		if (left.next == null) {
			left.next = right;
			return left;
		}
		reverse = reverseUtil(left.next, left);
		left.next = right;
		return reverse;
	}

	// The list must be in a sorted order for this to work
	public void removeDuplicates() {
		Node temp = head;
		while (temp != null) {
			if (temp.next != null && temp.data == temp.next.data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
	}

	public SingleLinkList copyList() {
		Node temp = head;

		Node headNode = null;
		Node tailNode = null;
		Node tempNode = null;

		if (temp == null) {
			return null;
		}
		headNode = new Node(temp.data, null);
		tailNode = headNode;
		temp = temp.next;
		while (temp != null) {
			tempNode = new Node(temp.data, null);
			tailNode.next = tempNode;
			tailNode = tempNode;
			temp = temp.next;
		}
		SingleLinkList list = new SingleLinkList();
		list.head = headNode;
		return list;
	}

	// hard to understand this, so please look carefully!!
	public SingleLinkList copyReversedList() {
		Node temp1 = null;
		Node temp2 = null;
		Node currentNode = head;
		while (currentNode != null) {
			temp2 = new Node(currentNode.data, temp1);
			currentNode = currentNode.next;
			temp1 = temp2;
		}
		SingleLinkList list = new SingleLinkList();
		list.head = temp1;
		return list;
	}

	// compare using non-recursive way
	public boolean compareList(SingleLinkList list) {
		Node head1 = head;
		Node head2 = list.head;
		while (head1 != null && head2 != null) {
			if (head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 == null && head2 == null) {
			return true;
		}
		return false;
	}

	// comparison using recursive-way
	public boolean compareListUsingRecursion(SingleLinkList list) {
		return compareUtil(head, list.head);
	}

	private boolean compareUtil(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return true;
		} else if (head1 == null || head2 == null || (head1.data != head2.data)) {
			return false;
		} else {
			return compareUtil(head1.next, head2.next);
		}
	}

	public String nthNodeFromBegin(int index) {
		if (index > getSize() || index < 1) {
			return null;
		}
		int count = 0;
		Node temp = head;
		while (temp != null && count < index - 1) {
			count++;
			temp = temp.next;
		}
		return temp.data;
	}

	public String nthNodeFromEnd(int index) {
		int size = getSize();
		int sindex;
		if (size != 0 && size < index) {
			return null;
		}
		sindex = size - index + 1;
		return nthNodeFromBegin(sindex);
	}

	public boolean isExist(String item) {
		Node temp = head;
		while (temp != null) {
			if (temp.data.equals(item)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public int getSize() {
		return size;
	}
}