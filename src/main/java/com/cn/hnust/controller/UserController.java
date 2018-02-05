package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.Page;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

//	@RequestMapping("/showUser")
//	public String toIndex(HttpServletRequest request, Model model) {
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "showUser";
//	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	 //登录验证
    @RequestMapping("/index")  
    public String login(HttpSession session,User user)throws Exception{  
        //调用serivce进行用户身份验证  
        //...  
          
        //在session中保存用户身份信息  
        session.setAttribute("username", user.getUser_name());  
        //重定向主页
        return "redirect:/user/showAllUser.do";  
    }  
	
	
	
	@RequestMapping("/showAllUser")
	public String showAllUser(HttpServletRequest request, Model model, User user) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		int totalCount = this.userService.getCount();
		List<User> userList =new ArrayList<User>();
		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		user.setStartPos(page.getStartPos());
		user.setPageSize(page.getPageSize());
		userList = this.userService.getUsers(user);
		model.addAttribute("user", userList);
	    model.addAttribute("page", page);  
		return "showUser";
	}
}
