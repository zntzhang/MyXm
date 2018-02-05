package com.cn.hnust.cxf;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	public String say(String str);
}
