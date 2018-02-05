package com.cn.hnust.service;  
  
import java.util.List;

import com.cn.hnust.pojo.User;  
  
public interface IUserService {  
    public User getUserById(int userId);

	void insertUser(List<User> users);

	public List<User> getUsers(User user);

	public int getCount();  
}  