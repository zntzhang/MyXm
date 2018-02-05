package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.User;

public interface IUserDao {

	public User selectByPrimaryKey(int userId);

	public void insert(User user);

	public List<User> getUsers(User user);

	public int getCount();

}
