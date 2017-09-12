package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.User;

public interface UserDao2 {
    public User selectUserById(Integer id) throws Exception;
    
    public List<User> selectUserByUsername(String name) throws Exception;
    public List<User> selectUserByUsername1(String name) throws Exception;
}
