package com.gzqf.webui.service;

import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.UserDto;

public interface WebUiMemberPayService {

    Order pay(Order order);
}
