package mq;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MqTest {
	@Test
	public void test1() {
		String[] xmls = new String[] { "classpath:spring-mybatis.xml", "classpath:spring-jms.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmls);
		context.start();
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		} // 按任意键退出
	}
}
