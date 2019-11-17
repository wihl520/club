package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.clubapi.dao.ApiMemberPayDao;
import com.gzqf.clubapi.dao.OrderDao;
import com.gzqf.clubapi.service.ApiMemberPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiMemberPayServiceImpl extends BaseServiceImpl<Order,ApiMemberPayDao> implements ApiMemberPayService {


}
