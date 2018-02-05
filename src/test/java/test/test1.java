package test;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;  

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class test1 {
	 private static Logger logger = Logger.getLogger(test1.class);  
	    @Resource  
	    private IUserService userService = null;  
	  
	  
	    @Test  
	    public void test1() {  
	        User user = userService.getUserById(1);  
	        logger.info(JSON.toJSONString(user));  
	    }  
	    
	    //测试回滚
	    @Test  
	    public void testTransaction(){  
	        List<User> users = new ArrayList<User>();  
	        for(int i=1;i<5;i++){  
	            User user = new User();  
	            user.setAge(i);  
	            user.setPassword(i+"111111");  
	            user.setUser_name("测试"+i);    
	            users.add(user);  
	        }  
	        this.userService.insertUser(users);  
	    }  
}
