package com.cq.projecttwo.mesdome.dome;

import java.util.ArrayList;
import java.util.List;

import com.cq.projecttwo.mesdome.entry.UserEntity;
import com.cq.projecttwo.mesdome.utils.ListUtils;

/**
 * 消息发送
 * @author Administrator
 *
 */
public class MsgSend {
	/**
	 * 1、初始化用户数据
	 * 2、计算需要多个线程，并计算出每个线程的需要传输的数量
	 * 3、发送短信
	 * 
	 */
	public static void main(String[] args) {
		List<UserEntity> userEntities= init();
		int  userThreadPage=2;
		//调用工具得到线程数量
		List<List<UserEntity>> splitList=ListUtils.splitList(userEntities,userThreadPage);
		//线程长度
		int TreadNumber=splitList.size();
		System.out.println("线程数量"+TreadNumber);
		for(int i=0;i<TreadNumber;i++){
			//得到每个当前循环线程的用户数量
			List<UserEntity> list=splitList.get(i);
			//传递的是每个线程所需要传送的数据量
			
			UserThread userThread=new UserThread(list);
			//开始发送
			new Thread(userThread).start();	
		
		}
	
	
	
	}
	//1
	private static List<UserEntity> init(){
		List<UserEntity> userEntities=new ArrayList<UserEntity>();
		for(int i=0;i<10;i++){
			UserEntity userEntity=new UserEntity();
			userEntity.setUserId("userId"+i);
			userEntity.setUserName("UserName"+i);
			userEntities.add(userEntity);
		}
		return userEntities;
	}
	
	
}
