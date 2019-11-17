package com.gzqf.clubapi.service.impl;



import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.clubapi.dao.ApiApplianceDao;
import com.gzqf.clubapi.service.ApiApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiApplianceServiceImpl extends BaseServiceImpl<Appliance,ApiApplianceDao> implements ApiApplianceService {
    @Autowired
    private ApiApplianceDao apiApplianceDao;
    @Override
    public void useById(Long memberId,Long id) {
        apiApplianceDao.useById(memberId,id);
    }

    @Override
    public void backById(Long id) {
        apiApplianceDao.backById(id);
    }

}
