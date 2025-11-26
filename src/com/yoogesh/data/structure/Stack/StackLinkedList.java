package com.yoogesh.data.structure.Stack;

public class StackLinkedList {

	Node head = null;
	int size = 0;

	class Node {

		int value;
		Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int value) {
		head = new Node(value, head);
		size++;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return head.value;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int temp = head.value;
		head = head.next;
		return temp;
	}

	public void print() {
		Node temp = head;
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		while (temp != null) {
			System.out.print(temp.value + " ==> ");
			temp = temp.next;
		}
		System.out.println("NULL");
	}
}
