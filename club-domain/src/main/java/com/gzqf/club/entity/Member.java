package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import com.gzqf.club.utils.PattenUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * <p>Description: </p>
 * 会员的实体类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:51
 **/
@Data
public class Member extends BaseEntity {

    /**
     * 会员的名字
     */
    @Length(max = 15, min = 4, message = "用户名长度必须要为4到18位")
    private String name;

    /**
     * 密码
     * @Length(max = 18,min = 6,message = "密码长度必须要为6到18位")
     */
    private String password;

    /**
     * 邮件地址
     */
    @Pattern(regexp = PattenUtil.EMAIL_PATTEN, message = "邮件地址格式不合法")
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 会员等级
     */
    private Integer level;

    /**
     * 会员电话
     */
    @Pattern(regexp = PattenUtil.PHONE_PATTEN, message = "电话格式不合法")
    private String phone;

    /**
     * 注册日期
     */
    private Date created;

    /**
     * 修改信息日期
     */
    private Date updated;

    /**
     * 所属教练的编号id
     */
    private Long coachId;

    /**
     * 会员头像地址
     */
    private String pic;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 会员天数
     */
    private int memberDay;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 健身计划
     */
    private String plan;

    /**
     * 健身锻炼的部位
     */
    private String wantBuild;

    /**
     * 是否教练
     */
    private int isCoach;

    /**
     * 是否删除
     */
    private int isDel;
}
