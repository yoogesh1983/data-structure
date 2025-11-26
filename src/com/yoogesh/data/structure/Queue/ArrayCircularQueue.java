package com.yoogesh.data.structure.Queue;

public class ArrayCircularQueue {
	int front;
	int rear;
	int count;
	int size;
	int[] Q;

	public ArrayCircularQueue() {
		front = -1;
		rear = -1;
		count = 0;
		size = 5;
		Q = new int[size];
	}

	public void insert(int value) {
		if (count == size) {
			System.out.println("Queue is full");
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % size;
		}
		Q[rear] = value;
		count++;
	}

	public void delete() {
		if (count == 0) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Deleted item is: " + Q[front]);
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front+1) % size;
			count--;
		}
	}
	
	public void display() {
		if (count == 0) {
			System.out.println("Queue is empty");
			return;
		}
		int i = front;
		if(front <= rear) {
			while(i<=rear) {
				System.out.print(Q[i] + " ");
				i++;
			}
		} else {
			while(i <= rear) {
				System.out.print(Q[i] + " ");
				i = (i+1)%size;
			}
		}
		System.out.println();
	}
}
