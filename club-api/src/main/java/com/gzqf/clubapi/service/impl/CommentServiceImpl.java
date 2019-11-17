package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Comment;
import com.gzqf.club.entity.CommentInfo;
import com.gzqf.clubapi.dao.CommentDao;
import com.gzqf.clubapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentInfo> getComment() {
        return commentDao.getComment();
    }
}
