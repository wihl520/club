package com.gzqf.club.dao;

import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends BaseDao<User> {


    User getByNameAndPassword(@Param("userName") String userName,@Param("password") String password);
}
