package com.example.service;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class Userservice {
	
	@Resource 
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	
	public void del(Long id) {
		userDao.deleteById(id);
	}
	
	public User findById(Long id) {
		return userDao.findById(id).orElse(null);
	}
	
	public Page<User> findPage(Integer pageNum, Integer pageSize, String name){
		Sort sort = Sort.by(Sort.Direction.DESC, "create_time");
		PageRequest request = PageRequest.of(pageNum-1, pageSize,sort);
		return userDao.findNameLike(name, request);
	}

}
 