package com.cq.projecttwo.safetydome.code;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *   线程同步问题
 *   //1、定义100张票
 *   //2、创建两个线程获取这100张票（保证数据原子性）
 *   Java内存模型：主内存、每个线程都有一个（私有本地内存）
 *   java三大特性：原子性、可见性、有序性
 *  
 * @author Administrator
 *
 */
public class SynchronizationSafetThread implements Runnable{
	
	private static   int ticket=100;
	private static boolean flag=true;
	private Object obj=new Object();
		@Override
		public void run() {
			if(flag){
				while (ticket>0) {
								
					synchronized (SynchronizationSafetThread.class) {//同步代码块(锁可以是任意类型的)
						if(ticket>0){
							try {
								Thread.sleep(50);
							} catch (Exception e) {
								// TODO: handle exception
							}
							System.out.println(Thread.currentThread().getName()+",出售第"+(100-ticket+1)+"票");
							ticket--;
						}
					}
					
				}
			}else{
				
				while (ticket>0) {
					salf();
					
				}
				
			}
			
			
	}
	/*	private void salf(){
			synchronized (this) {//同步代码块(锁可以是任意类型的)
				if(ticket>0){
					try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}
					System.out.println(Thread.currentThread().getName()+",出售第"+(100-ticket+1)+"票");
					ticket--;
				}
			}
		}*/
		/*private synchronized void salf(){//同步函数（默认的是this锁）
				if(ticket>0){
					try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}
					System.out.println(Thread.currentThread().getName()+",出售第"+(100-ticket+1)+"票");
					ticket--;
				}
			
		}*/
		private static  synchronized void salf(){//静态同步函数（默认的是当前字节码文件锁）
			if(ticket>0){
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName()+",出售第"+(100-ticket+1)+"票");
				ticket--;
			}
		
	}
public static   class Dome2{
			public static void main(String[] args) throws InterruptedException {
				SynchronizationSafetThread synchronizationSafetThread=new SynchronizationSafetThread();
				//创建两个窗口
				new Thread(synchronizationSafetThread,"窗口1").start();
				//对比两种不同的锁的区别
					Thread.sleep(40);
					SynchronizationSafetThread.flag=false;
				new Thread(synchronizationSafetThread,"窗口2").start();
			}
		}
		
}


