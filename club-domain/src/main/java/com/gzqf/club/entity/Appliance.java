package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;

/**
 * <p>Description: </p>
 * 健身器械的实体类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:44
 **/
@Data
public class Appliance extends BaseEntity {
    /**
     * 父类
     */
    private Appcat parent;

    /**
     * 器械的名字
     */
    private String name;

    /**
     * 器械的数量
     */
    private Integer total;

    /**
     * 器械的描述
     */
    private String desc;

    /**
     * 器械的图片
     */
    private String pic;
    /**
     * 使用器械的用户的id
     */
    private Long userId;

    /**
     * 器械的使用方式
     */
    private String useWay;

    /**
     * 器械的状态，是否在使用
     */
    private Integer state;

    /**
     * 器械的使用情况，是否良好
     */
    private Integer flag;

}
