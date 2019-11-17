package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClubapiDao {
    List<Member> findList();
    List<Appcat> findAppcatAll();

    Member findcoachInfo(Long id);

    List<Member> findStuList(Long id);
}
