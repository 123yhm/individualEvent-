package com.cq.projecttwo.safetydome.code;

public class ThreadLocaDemo2 extends Thread {
	private ThreadLocaThread res;

		public ThreadLocaDemo2(ThreadLocaThread res) {
			this.res = res;
		}

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
			}

		}

}
