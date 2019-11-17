package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * <p>Description: </p>
 * 健身器材分类实体
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:43
 **/
@Data
public class Appcat extends BaseEntity {
    /**
     * 父级数据
     */
    private Appcat parent;

    /**
     * 器械(分类)名
     */
    @Length(min = 2, message = "器械(分类)名不能为空！")
    private String name;

    /**
     * 图片链接地址
     */
    private String pic;

    /**
     * 器材描述
     */
    @NotBlank(message = "器械描述不能为空!")
    private String describe;

    /**
     * 使用方式介绍
     */
    private String mode;

    /**
     * 器材锻炼要点
     */
    private String play;

    /**
     * 视屏播放地址
     */
    private String video;

    /**
     * 分类id
     */
    private String cattegoryId;

    /**
     * 是否是父类
     */
    private int isParent;
}
