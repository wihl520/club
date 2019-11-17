package com.gzqf.clubapi.service.impl;


import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.clubapi.dao.OrderDao;
import com.gzqf.clubapi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,OrderDao> implements OrderService {
    @Override
    public void deleteMutil(List ids) {
        dao.deleteMutil(ids);
    }

    @Override
    public Order getOrderById(Long id) {
       return dao.getOrderById(id);
    }
}
