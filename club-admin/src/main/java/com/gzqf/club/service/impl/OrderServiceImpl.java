package com.gzqf.club.service.impl;

import com.gzqf.club.dao.OrderDao;
import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDao> implements OrderService {
    @Override
    public void deleteMutil(List ids) {
        dao.deleteMutil(ids);
    }
}
