package com.gzqf.club.entity;

import com.gzqf.club.persistence.BaseEntity;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * 健身小贴士实体
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:09
 **/
@Data
@Component
public class Tips extends BaseEntity {
    /**
     * 健身小贴士内容
     */
    private String content;

    /**
     * 健身器材
     */
    private Appcat parent;
    /**
     * 健身小贴士标题
     */
    private String title;

    /**
     * 健身小贴士副标题
     */
    private String subTitle;

    /**
     * 健身小贴士图片地址
     */
    private String pic;
}
