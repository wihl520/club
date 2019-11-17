package com.gzqf.club.persistence;

import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 * 通用的 Sevice 继承类
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:15
 **/
@Service
public interface BaseService<T extends BaseEntity> {
    /**
     * 保存,在共同模块定义共同的方法
     *
     * @param t 实体类
     * @return 处理响应的信息
     */
    Result save(T t);

    /**
     * 删除是按id删除，传入的是long类型
     *
     * @param id 删除id
     * @return 处理响应的信息
     */
    Result delete(Long id);

    /**
     * 修改实体数据
     *
     * @param t 实体数据
     * @return 处理响应的信息
     */
    Result update(T t);

    /**
     * 根据实体数据查询数据集
     *
     * @param t 实体数据
     * @return 处理响应的信息
     */
    Result findList(T t);

    /**
     * 查询数据
     *
     * @param user 实体类数据
     * @return 处理响应的信息
     */
    Result pageList(T user);

    /**
     * 通过id查询的方法
     *
     * @param id 查询id
     * @return 实体类
     */
    T getById(Long id);
}
