package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

/**
 * <p>Description: </p>
 * 评论信息
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:04
 **/
@Data
public class CommentInfo extends BaseEntity {
    private String commentContent;
    private String commentContent1;
}
