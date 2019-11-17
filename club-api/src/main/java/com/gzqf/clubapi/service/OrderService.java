package com.gzqf.clubapi.service;

import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseService;

import java.util.List;

public interface OrderService extends BaseService<Order> {

    void deleteMutil(List ids);

    Order getOrderById(Long id);
}
