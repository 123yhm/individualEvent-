package com.cq.projecttwo.thread;
/**
 * t1.join：让其他线程等待，直到t1线程循环执行完毕
 * @author 明
 *
 */
public class ThreadJoinDome3 {
		public static void main(String[] args) {
		Thread thread1=	new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0;i<20;i++){
						System.out.println("手机"+i);
					}
					
				}
			});
		
		Thread thread2=	 new Thread(new Runnable() {
			
				@Override
				public void run() {
					try {
						thread1.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int i=0;i<20;i++){
						System.out.println("平板"+i);
					}
					
				}
			});
		
		Thread thread3=	 new Thread(new Runnable() {
		
		@Override
		public void run() {
			try {
				thread2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<20;i++){
				System.out.println("电脑"+i);
			}
			
		}
	});
		thread1.start();
		thread2.start();
		thread3.start();
		
		}
}
