package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ApiMemberRegistDao extends BaseDao<Member> {
    //验证用户名是否存在
    Member VerifyMemberName(@Param("name") String name);

    //验证电子邮箱是否存在
    Member VerifyMemberEmail(@Param("email") String email);

    //注册用户
    void registmember(Member member);
    //查
    Member getIdAndPassword(@Param("id") Long id,@Param("password") String password);
    //改
    void updatepassword(@Param("id")Long id,@Param("password") String password);
}
