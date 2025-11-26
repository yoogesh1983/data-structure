package com.yoogesh.data.structure.Queue.DeQueue;

public class LinkedListDeQueue {

	Node front;
	Node rear;
	int size;

	public LinkedListDeQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public void insertAtFront(int data) {
		Node newNode = new Node(data, null);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.next = front;
			front = newNode;
		}
		size++;
	}

	public void insertAtRear(int data) {
		Node newNode = new Node(data, null);
		if (front == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	public void deleteFromFront() {
		if (front == null) {
			System.out.println("DQ is empty");
			return;
		}
		System.out.println("Deleted item is: " + front.data);
		front = front.next;
		size--;
	}

	public void deleteFromRear() {
		if (front == null) {
			System.out.println("DQ is empty");
			return;
		}
		System.out.println("Deleted item is: " + rear.data);
		if (front == rear) {
			front = null;
			rear = null;
		} else {
			Node temp = front;
			while (temp.next != rear) {
				temp = temp.next;
			}
			rear = temp;
			rear.next = null;
		}
		size--;
	}

	public void display() {
		if(front == null) {
			System.out.println("DQ is empty");
			return;
		}
		Node temp = front;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
