package com.cq.projecttwo.safetydome.code;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  AtomicInteger是一个提供原子操作的Integer类，通过线程安全的非阻塞的方式操作加减
 * @author 明
 * 避免使用Volatile,用AtomincInteger进行代替保证线程的原子性
 *
 */
public class AtomicIntegerThread extends Thread{
		private static  AtomicInteger atomicInteger=new AtomicInteger(0);
		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				atomicInteger.incrementAndGet();//以原子方式将当前值加 1。相当于Java中的atomicInteger++;
			}
			System.out.println(getName()+"----当前的值为："+atomicInteger.get());//获取当前线程的结束值
		}
public static class testAtomicInteger{
			public static void main(String[] args) {
				AtomicIntegerThread[] atomicIntegerThread=new AtomicIntegerThread[10];
				
				//创建10个线程
				for (int i = 0; i < atomicIntegerThread.length; i++) {
					atomicIntegerThread[i]=new AtomicIntegerThread();
				}
				//循环每个线程获取的值
				for (int i = 0; i < atomicIntegerThread.length; i++) {
					atomicIntegerThread[i].start();
				}
			}
		}
}
