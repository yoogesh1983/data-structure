package com.yoogesh.data.structure.Queue;

public class ArrayNormalQueue {

	int front;
	int rear;
	int size;
	int[] Q;

	public ArrayNormalQueue() {
		front = -1;
		rear = -1;
		size = 5;
		Q = new int[size];
	}

	public void insert(int value) {
		if (rear == size) {
			System.out.println("Queue is full");
			return;
		}
		if (front == rear) {
			front = 0;
			rear = 0;
		}
		Q[rear] = value;
		rear++;
	}

	public void delete() {
		if (front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Deleted object is:" + Q[front]);
		front++;
		if (front == rear) {
			front = -1;
			rear = -1;
		}
	}
	
	public void display() {
		if(front == rear) {
			System.out.println("Queue is empty");
			return;
		}
		for(int i=front; i<rear; i++) {
			System.out.print(Q[i] + " ");
		}
		System.out.println();
	}

}
