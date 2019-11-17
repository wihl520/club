package com.gzqf.club.persistence;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>
 * 使用泛型抽取共同的dao方法 CRUD
 * 1.T 是任意一个BaseEntity的子类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:17
 **/
public interface BaseDao<T extends BaseEntity> {

    /**
     * 写入一个新的实体
     *
     * @param t 实体类
     **/
    void save(T t);

    /**
     * 查询列表
     *
     * @param t 实体类
     * @return 实体数据集
     */
    List<T> findList(T t);

    /**
     * 更新实体类中的信息
     *
     * @param t 实体类
     **/
    void update(T t);

    /**
     * 删除一条记录
     *
     * @param id 删除id
     */
    void delete(Long id);

    /**
     * 查询结果条数
     *
     * @param t 实体类
     * @return long
     */
    long findListCount(T t);

    /**
     * 删除一条记录
     *
     * @param id 删除的Id
     * @return 实体类
     */
    T getById(Long id);
}
