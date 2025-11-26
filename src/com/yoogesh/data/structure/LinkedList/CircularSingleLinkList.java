package com.yoogesh.data.structure.LinkedList;

public class CircularSingleLinkList {

	Node tail;
	int size = 0;

	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data, null);
		if (size == 0) {
			tail = newNode;
			newNode.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}

	public void addLast(int data) {
		Node newNode = new Node(data, null);
		if (size == 0) {
			tail = newNode;
			newNode.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public void addPos(int index, int data) {
		Node newNode = new Node(data, null);
		if (size == 0) {
			tail = newNode;
			newNode.next = newNode;
		} else {
			if (index == 0) {
				Node temp = tail.next;
				newNode.next = temp;
				tail.next = newNode;
				return;
			}
			Node temp = tail.next;
			int count = 0;
			while (temp.next != tail && count < index - 1) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}

	public void removeFirst() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}
		// if you have only one element in a list
		if (tail == tail.next) {
			tail = null;
		} else {
			tail.next = tail.next.next;
		}
		size--;
	}

	public void removeLast() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}
		// if you have only one element in a list
		if (tail == tail.next) {
			tail = null;
		} else {
			Node temp = tail.next;
			while (temp.next != tail) {
				temp = temp.next;
			}
			temp.next = tail.next;
			tail = temp;
		}
		size--;
	}

	public void deleteElement(int data) {
		if (size == 0) {
			System.out.println("List is empty");
		}
		Node prev = tail;
		Node curr = tail.next;
		Node start = tail.next;

		if (curr.data == data) {
			if (curr == curr.next) {
				tail = null;
			} else {
				tail.next = tail.next.next;
			}
			return;
		}
		prev = curr;
		curr = curr.next;
		while (curr != start) {
			if (curr.data == data) {
				if (curr == tail) {
					tail = prev;
				}
				prev.next = curr.next;
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		return;
	}

	boolean search(int value) {
		Node temp = tail;
		for (int i = 0; i < size; i++) {
			if (temp.data == value) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void printList() {
		if (size == 0) {
			System.out.println("List is empty");
		}
		Node temp = tail.next;
		while (temp != tail) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

}
