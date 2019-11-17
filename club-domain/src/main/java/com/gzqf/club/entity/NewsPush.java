package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>Description: </p>
 * 新闻信息
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:06
 **/
@Data
public class NewsPush extends BaseEntity {
    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻配图
     */
    private String newsPic;

    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 教练信息
     */
    private Member coach;

    /**
     * 会员信息
     */
    private Member member;

    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newsDate;

    /**
     * 新闻地址
     */
    private String newsAdress;
    /**
     * 点赞数
     */
    private int newsPraise;

    /**
     * 点赞人员
     */
    private String praisePerson;
}
