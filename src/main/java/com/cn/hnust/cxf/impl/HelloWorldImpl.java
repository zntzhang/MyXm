package com.cn.hnust.cxf.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component("helloWorld")
@WebService
public class HelloWorldImpl {
	public String say(String str) {
		return "Hello"+str;
	}
}
