/**
 * 
 */
package com.cq.projecttwo.safetydome.code;

/**
 * @author 明
 * 
 *         Volatile:强制到主内存中去重新刷新当前值---通知给其他线程（但不保证线程的原子性）
 *         否则则不会更新主内存中的状态，还是为true
 *
 */
public class VolatileThread extends Thread {
	public volatile boolean flag = true;

	@Override
	public void run() {
		System.out.println("循环执行开始...");
		while (flag) {

		}
		System.out.println("循环执行结束...");
	}
	public  void sale(boolean flag){
		this.flag=flag;
	}
	public static  class VolatileTest{
		public static void main(String[] args) throws InterruptedException {
			VolatileThread volatileThread=new VolatileThread();
			volatileThread.start();
			Thread.sleep(40);
			volatileThread.sale(false);
			System.out.println("?????"+volatileThread.flag);
		}
	}
}

