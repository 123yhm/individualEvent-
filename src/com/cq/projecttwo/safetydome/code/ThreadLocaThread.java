package com.cq.projecttwo.safetydome.code;
/**
 * 	ThreadLoca:提高一个线程的局部变量，访问某个线程拥有自己的局部变量
 * @author 明
 *
 */
public class ThreadLocaThread {
	// 生成序列号共享变量 
		public static Integer count = 0;
		public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
			protected Integer initialValue() {

				return 0;
			};

		};

		public Integer getNum() {
			int count = threadLocal.get() + 1;
			threadLocal.set(count);
			return count;
		}
	


}

	
			
		
 