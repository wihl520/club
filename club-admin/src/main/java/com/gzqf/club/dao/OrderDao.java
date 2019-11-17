package com.gzqf.club.dao;

import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends BaseDao<Order> {
    void deleteMutil(@Param("ids") List ids);
}
