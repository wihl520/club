package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description: </p>
 * 会员期限表
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:54
 **/
@Data
public class MemberDeadline extends BaseEntity {
    /**
     * 会员Id
     */
    private int memberId;

    /**
     * 会员实体
     */
    private Member member;

    /**
     * 注册日期
     */
    private Date registDate;

    /**
     * 开始日期
     */
    private Date beginDate;

    /**
     * 总天数
     */
    private int totalDay;

    /**
     * 是否暂停状态
     */
    private int restStatus;

}
