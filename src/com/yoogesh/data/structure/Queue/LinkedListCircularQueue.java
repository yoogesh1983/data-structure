package com.yoogesh.data.structure.Queue;

public class LinkedListCircularQueue {
	Node front;
	Node rear;

	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public void insert(int data) {
		Node newNode = new Node(data, null);
		if(front == null) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		rear = newNode;
		rear.next = front;
		
	}

	public void delete() {
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Deleted item is: " + front.data);
		if(front == rear) {
			front = null;
			rear = null;
		} else {
			front = front.next;
			rear.next = front;
		}
	}

	public void display() {
		Node temp = front;
		if(temp == null) {
			System.out.println("Queue is empty");
			return;
		}
		while(temp.next != front) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
}
