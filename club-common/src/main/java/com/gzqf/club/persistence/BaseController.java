package com.gzqf.club.persistence;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Description: </p>
 * 通用的Controller 控制器继承
 * 定义泛型的方法，用来获取泛型的前置Service层对象和泛型的前置实体类对象
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:15
 **/
public class BaseController<S extends BaseService, T extends BaseEntity> {

    /**
     * 使用protected定义，主要给继承的子类用
     */
    @Autowired
    protected S Service;

}
