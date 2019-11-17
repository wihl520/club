package com.gzqf.club.entity;


import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * <p>Description: </p>
 * 用户模块实体
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:41
 **/
@Data
public class User extends BaseEntity {

    /**
     * 管理员表
     */
    @Length(max = 18, min = 4, message = "用户名长度必须要为4到18位")
    private String userName;
    /**
     * 管理员密码
     */
    @Length(max = 18, min = 6, message = "密码长度必须要为6到18位")
    private String password;
    /**
     * 管理员电话
     */
    private String phone;
    /**
     * 管理员电子邮箱
     */
    private String email;
}
