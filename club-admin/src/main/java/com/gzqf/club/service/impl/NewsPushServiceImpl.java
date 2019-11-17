package com.gzqf.club.service.impl;

import com.gzqf.club.dao.INewsPushDao;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.service.INewsPushService;
import org.springframework.stereotype.Service;

@Service
public class NewsPushServiceImpl extends BaseServiceImpl<NewsPush, INewsPushDao> implements INewsPushService {
}
