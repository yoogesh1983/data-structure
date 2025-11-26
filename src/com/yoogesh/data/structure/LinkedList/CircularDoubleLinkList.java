package com.yoogesh.data.structure.LinkedList;

public class CircularDoubleLinkList {

	Node head = null;
	Node tail = null;
	int size = 0;

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public void printList() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}
		Node temp = tail.next;
		while (temp != tail) {
			System.out.print(temp.data + " ==> ");
		}
		System.out.println(temp.data);
	}

	public void addHead(int data) {
		Node newNode = new Node(data, null, null);
		if (size == 0) {
			tail = head = newNode;
			newNode.next = newNode;
			newNode.prev = newNode;
		} else {
			newNode.next = head;
			newNode.prev = head.prev;
			head.prev = newNode;
			newNode.prev.next = newNode;
			head = newNode;
		}
		size++;
	}

	public void addTail(int data) {
		Node newNode = new Node(data, null, null);
		if (size == 0) {
			tail = head = newNode;
			newNode.next = newNode;
			newNode.prev = newNode;
		} else {
			newNode.next = tail.next;
			newNode.prev = tail;
			tail.next = newNode;
			newNode.next.prev = newNode;
			tail = newNode;
		}
		size++;
	}

	public void removeHead() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}
		size--;
		if (size == 0) {
			head = null;
			tail = null;
			return;
		}
		Node temp = head.next;
		temp.prev = tail;
		tail.next = temp;
		head = temp;
	}

	public void removeTail() {
		if (size == 0) {
			System.out.println("List is empty");
			return;
		}
		size--;
		if (size == 0) {
			head = null;
			tail = null;
			return;
		}
		Node temp = tail.prev;
		temp.next = head;
		head.prev = temp;
		tail = temp;
	}
}
