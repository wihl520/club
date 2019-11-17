package com.gzqf.club.web.support;

import lombok.Data;

import java.util.List;

/**
 * <p>Description: </p>
 * 查询翻页数据集
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 16:23
 **/
@Data
public class PageResult<T> {
    /**
     * 总条数
     */
    private long count;

    /**
     * 数据集合
     */
    private List<T> list;

    /**
     * 当前第几页
     */
    private int current;

    /**
     * 每页多少条记录
     */
    private int pageSize;

}
