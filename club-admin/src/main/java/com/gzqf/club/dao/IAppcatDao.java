package com.gzqf.club.dao;

import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppcatDao extends BaseDao<Appcat> {

    //依据ID查询下属分类
    List<Appcat> queryChildrenAppcat(@Param("id") Long id);
    //设置是父节点
    void setIsParentTrue(@Param("id") Long id);
    //设置为非父节点
    void setIsParentFalse(@Param("id") Long id);
}
