package com.cn.hnust.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1......afterHandle");  
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		 System.out.println("HandlerInterceptor1......postHandle"); 
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		//获取请求的url  
        String url=req.getRequestURI();  
        //判断url是否是公开地址(实际使用时将公开地址配置到配置文件中)  
        if(url.indexOf("index.do")>=0){  
            //如果要进行登录提交，放行  
            return true;  
        }
        //判断session 
        HttpSession session=req.getSession();
        //从session中取出用户份信息 
        String username=(String)session.getAttribute("username");
        if(username!=null){  
            //身份存在，放行  
            return true;  
        }
      //执行这里表示用户身份需要验证，跳转到登录界面  
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, res);  
        //return false表示拦截，不向下执行  
        //return true表示放行          
        return false;  
	}

}
