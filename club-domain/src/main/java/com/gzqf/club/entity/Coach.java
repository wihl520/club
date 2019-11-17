package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

/**
 * <p>Description: </p>
 *  健身教练实体类
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:48
 **/
@Data
public class Coach extends BaseEntity {

    /**
     * 性别
     */
    private Integer sex;
    /**
     * 图片
     */
    private String pic;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 技能方向
     */
    private String skill;

    /**
     * 教练密码
     */
    private String password;

    /**
     * 点子邮件
     */
    private String email;
}
