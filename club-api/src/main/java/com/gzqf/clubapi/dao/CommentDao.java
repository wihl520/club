package com.gzqf.clubapi.dao;


import com.gzqf.club.entity.CommentInfo;
import com.gzqf.club.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentDao{
        List<CommentInfo> getComment();
}
