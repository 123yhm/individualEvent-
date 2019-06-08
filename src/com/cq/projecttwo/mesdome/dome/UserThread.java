package com.cq.projecttwo.mesdome.dome;

import java.util.List;

import com.cq.projecttwo.mesdome.entry.UserEntity;

public class UserThread implements Runnable{
	private List<UserEntity> userEntry;
	/**
	 * 初始化指定值
	 * @param userEntry
	 */
	 public UserThread(List<UserEntity> userEntry) {

	 this.userEntry=userEntry;
	 
	 }
	
	
	@Override
	public void run() {//使用线程发送消息
		// TODO Auto-generated method stub
		for (UserEntity userEntity : userEntry) {
			System.out.println("TradName"+Thread.currentThread().getName()+"用户id"+userEntity.getUserId()
					+"用户名称"+userEntity.getUserName());
			
		}
		System.out.println();
	}

}
