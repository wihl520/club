package com.gzqf.club.web.support;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * <p>Description: </p>
 * 分页参数配置
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:59
 **/
@Data
public class Page {
    /**
     * 每页的条数,赋予一个初始的值，当登录成功的时候使用查询
     */
    @Value("10")
    private int pageSize;

    /**
     * 查询起始条
     */
    private int start;

    /**
     * 当前第几页，赋予一个初始的值，当登录成功的时候使用查询
     */
    @Value("1")
    private int current;

    /**
     * 查询起始条
     */
    public int getStart() {
        return (current - 1) * pageSize;
    }
}
