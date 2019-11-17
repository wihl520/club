package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.NewsPush;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PushDao {
    List<NewsPush> getPush();
    NewsPush getPushId(int id);
}
