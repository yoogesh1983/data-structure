package com.yoogesh.data.structure.LinkedList;

class DoubleLinkedList {

	private Node head;
	private int size = 0;

	class Node {
		private int data;
		private Node next;
		private Node prev;

		Node(int data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
			size++;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data, null, null);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public void addLast(int data) {
		Node newNode = new Node(data, null, null);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
	}

	public void deleteFirst() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			size--;
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		}
	}
	
	// Same as single-linkList
	public void deleteLast() {
		if (head == null) {
			System.out.println("List is empty");
		} else if (head.next == null) {
			head = null;
			size--;
		} else {
			// we need two pointers here since the right pointer will point to null at one point during an iteration and we want before node at that point
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
	
	public void deleteElement(Integer item) {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is empty");
			return;
		}
		if (temp.data == item) {
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
			size--;
			return;
		}
		
		Node temp1 = null;
		while (temp.next != null) {
			if (temp.next.data == item) {
				temp.next = temp.next.next;
				temp1 = temp.next;
				if(temp1 != null) {
					temp1.prev = temp;
				}
				size--;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void deleteElements(Integer item) {
		Node temp = head;
		if (temp == null) {
			System.out.println("List is empty");
			return;
		}
		if (temp.data == item) {
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
			size--;
			//return;
		}
		
		Node temp1 = null;
		while (temp.next != null) {
			if (temp.next.data == item) {
				temp.next = temp.next.next;
				temp1 = temp.next;
				if(temp1 != null) {
					temp1.prev = temp;
				}
				size--;
				//return;
			}
			
			if(temp.next != null) {
				temp = temp.next;
			}
		}
	}
	
	public void deleteElementPosition(int index) {
		if (index < 0 || index > size - 1) {
			System.out.println("Please provide an index from 0 to " + (size - 1));
			return;
		}
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (index == 0) {
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
			size--;
			return;
		}
		
		Node left = head;
		Node right = null;
		int count = 0;
		while (left.next != null && count < index) {
			if(count == index-1) {
				left.next = left.next.next;
				right = left.next;
				if(right != null) {
					right.prev = left;
				}
				size--;
				return;
			}
			left = left.next;
			right = left.next;
			count++;
		}
	}

	public void insert(int item, Integer index) {
		Node newNode = new Node(item, null, null);

		// if the position is -ve or greater than the current size, throw an exception
		if (index > size - 1 || index < 0) {
			System.out.println("index " + index + " is not valid!!");
			return;
		}

		// if empty list, insert at the front
		if (head == null) {
			head = newNode;
			return;
		}

		// if position is zero, insert at the front
		if (index == 0) {
			addFirst(item);
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
		newNode.prev = left;
		newNode.next = right;
		right.prev = newNode;
	}

	public void sortedInsertAsc(Integer item) {
		Node newNode = new Node(item, null, null);
		Node temp = head;

		if (temp == null) {
			head = newNode;
			return;
		}

		if (temp.data > item) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			return;
		}

		while (temp.next != null && temp.next.data < item) {
			temp = temp.next;
		}

		// this is only required for doubleLinklist. for single link list , if/else is
		// not required
		if (temp.next != null) {
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
		} else {
			temp.next = newNode;
			newNode.prev = temp;
		}
	}

	// This is exactly same as Single-linkList
	public boolean isExist(Integer item) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == item) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public void reverse() {
		Node curr = head;
		Node temp = null;
		
		while (curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}
		if(temp != null) {
			head = temp.prev;
		}
	}
	
	
	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println("NULL ");
	}

	public int getSize() {
		return size;
	}
}
