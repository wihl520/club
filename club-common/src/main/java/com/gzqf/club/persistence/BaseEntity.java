package com.gzqf.club.persistence;

import com.gzqf.club.web.support.Page;

import java.util.Date;

/**
 * <p>Description: </p>
 * 所有的实体类的父类
 * 使用抽象的类型，实体类的父类，定义一些实体类之外的数据使用
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:55
 **/
public abstract class BaseEntity {

    /**
     * 库表Id
     */
    private Long id;
    /**
     * 添加日期
     */
    private Date created;

    /**
     * 更改日期
     */
    private Date updated;

    /**
     * 名称
     */
    private String name;

    /**
     * 用来做分页查询需要的分页数据
     */
    private Page page;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
