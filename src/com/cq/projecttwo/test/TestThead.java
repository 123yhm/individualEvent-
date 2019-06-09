package com.cq.projecttwo.test;

import org.junit.Test;

import com.cq.projecttwo.safetydome.code.ThreadLocaDemo2;
import com.cq.projecttwo.safetydome.code.ThreadLocaThread;
import com.cq.projecttwo.thread.ThreadRunbleDome1;
import com.cq.projecttwo.thread.ThreadThreadDome2;

/**
 * 
 * @author 明
 *
 *	线程测试
 */
public class TestThead {
	/**
	 * Runnable测试
	 */
	@Test
	public  void testRunble(){
		ThreadRunbleDome1 threadDome2=new ThreadRunbleDome1();
		Thread thread=new Thread(threadDome2);
		thread.run();
		
	}
	/**
	 * Thread 测试
	 */
	@Test
	public   void testThead(){
		ThreadThreadDome2 thread=new ThreadThreadDome2();
		System.out.println("线程开始");
		thread.start();
		System.out.println("线程结束");
	}
	/**
	 * 匿名内部类
	 */
	@Test
	public  void  testAnonymity(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <20; i++) {
					System.out.println("子线程"+i);
					
				}
				
			}
		}).start(); 
		for (int i = 0; i <10; i++) {
			System.out.println("主线程"+i);
		}
	}
	/**
	 * ThreadLoca
	 * 
	 */
	@org.junit.Test
	public  void testThreadLoca() {
		ThreadLocaThread res = new ThreadLocaThread();
		ThreadLocaDemo2 threadLocaDemo1 = new ThreadLocaDemo2(res);
		ThreadLocaDemo2 threadLocaDemo2 = new ThreadLocaDemo2(res);
		ThreadLocaDemo2 threadLocaDemo3 = new ThreadLocaDemo2(res);
		threadLocaDemo1.start();
		threadLocaDemo2.start();
		threadLocaDemo3.start();

	
	} 
}
