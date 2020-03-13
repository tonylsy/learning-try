package com.mybatisMe.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mybatisMe.entities.User;

@Repository
public interface UserDao {
    /**
     * 查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUser(int id) throws Exception;

    /**
     * 新增
     *
     * @param user
     */
    public void insertUser(User user) throws Exception;

    /**
     * 批量新增
     *
     * @param users
     */
    public void insertUsers(@Param("users") List<User> users) throws Exception;

    /**
     * 通过用户名称查询内容
     *
     * @param name
     * @return
     * @throws Exception
     */
    public List<User> selectUsersByName(@Param("name") String name) throws Exception;

    /**
     * 根据id更新用户
     *
     * @param id
     * @throws Exception
     */
    public void updateUser(User user) throws Exception;

    /**
     * 根据用户id删除数据
     *
     * @param id
     * @throws Exception
     */
    public void deleteUser(int id) throws Exception;
}
