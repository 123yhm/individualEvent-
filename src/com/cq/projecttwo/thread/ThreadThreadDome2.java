package com.cq.projecttwo.thread;

public class ThreadThreadDome2 extends Thread {
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println("当前数字" + i);
		}
	}
	
}
