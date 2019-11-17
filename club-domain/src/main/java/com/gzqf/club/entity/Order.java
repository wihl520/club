package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description: </p>
 * 缴费订单实体类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:08
 **/
@Data
public class Order extends BaseEntity {
    // 继承了BaseEntity一个专属的id

    /**
     * 支付日期
     */
    private Date payDate;

    /**
     * 续费金额
     */
    private int payAmount;

    /**
     * 续费天数
     */
    private int totalDay;

    /**
     * 支付方式
     */
    private String payWay;

    /**
     * 会员id
     */
    private int memberId;
}
