package com.hopu.service;

import com.hopu.entity.User;
import com.hopu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long i){
        return userMapper.selectByPrimaryKey(i);
    }

    @Transactional
    public void deleteUserById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
