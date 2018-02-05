package com.cn.hnust.activemq.service;

public class MqReceive {
	  public void onMessage(String msg){
	        System.out.println("接收到mq的消息");
	            System.out.println("消息为"+msg);
	    }
}
