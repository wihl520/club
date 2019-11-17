package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLoginDao extends BaseDao<Member> {

    Member getByNameAndPassword(@Param("name") String name,@Param("password") String password);


}
