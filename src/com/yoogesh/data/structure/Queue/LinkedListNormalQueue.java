package com.yoogesh.data.structure.Queue;

public class LinkedListNormalQueue {
	Node front;
	Node rear;
	int size;

	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public LinkedListNormalQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	public void display() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return;
		}
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void insert(int value) {
		Node newNode = new Node(value, null);
		if (front == null && rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	
	public void delete() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Deleted item is: " + front.data);
		front = front.next;
		size--;
	}
}
