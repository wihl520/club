package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description: </p>
 * 新闻评论
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:50
 **/
@Data
public class Comment extends BaseEntity {
    /**
     * 所属新闻id来自新闻信息表编号
     */
    private NewsPush newsPush;

    /**
     * 评论上一个评论的id
     */
    private Comment comment;

    /**
     * 评论者id来自member表
     */
    private Member member;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private Date commentDate;
}
