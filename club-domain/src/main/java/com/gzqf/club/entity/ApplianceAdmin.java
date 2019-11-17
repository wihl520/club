package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>Description: </p>
 * 器械的使用情况实体类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:47
 **/
@Data
public class ApplianceAdmin extends BaseEntity {
    /**
     * 父类 依据父ID得出父类信息
     */
    private Appcat parent;

    /**
     * 器械的名字
     */
    private String kitName;


    /**
     * 器械的使用天数
     */
    private Integer total;

    /**
     * 器械的图片
     */
    private String kitPic;

    /**
     * 使用器械的用户的id
     */
    private Long userId;

    /**
     * 器械开始使用时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDay;

    /**
     * 器械的状态，是否在使用
     */
    private Integer state;

    /**
     * 器械的使用情况，是否良好
     */
    private Integer flag;

}
