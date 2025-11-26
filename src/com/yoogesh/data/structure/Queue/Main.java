package com.yoogesh.data.structure.Queue;

public class Main {

	public static void main(String[] args) {

		LinkedListCircularQueue nq = new LinkedListCircularQueue();
		nq.insert(111);
		nq.insert(222);
		nq.insert(333);
		nq.insert(444);
		
		nq.delete();
		
		nq.display();
	}
}
