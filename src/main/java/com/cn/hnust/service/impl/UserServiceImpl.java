package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	/**
	 * 事务处理必须抛出异常，Spring才会帮助事务回滚
	 * 
	 * @param users
	 */

	@Transactional
	@Override
	public void insertUser(List<User> users) {
		for (int i = 0; i < users.size(); i++) {
			if (i < 10) {
				this.userDao.insert(users.get(i));
			} else {
				throw new RuntimeException();
			}
		}
	}

	@Override
	public List<User> getUsers(User user) {
		return this.userDao.getUsers(user);
	}

	@Override
	public int getCount() {
		return this.userDao.getCount();
	}
}