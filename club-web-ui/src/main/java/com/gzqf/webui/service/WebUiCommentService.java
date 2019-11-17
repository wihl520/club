package com.gzqf.webui.service;

import com.gzqf.club.entity.CommentInfo;
import com.gzqf.club.entity.NewsPush;

import java.util.List;

public interface WebUiCommentService {
    List<CommentInfo> getComment();
    NewsPush getPushId(int id);
}
