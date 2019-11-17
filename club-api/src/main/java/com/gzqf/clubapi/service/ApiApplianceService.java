package com.gzqf.clubapi.service;


import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.BaseService;


public interface ApiApplianceService extends BaseService<Appliance> {
    void useById(Long memberId,Long id);

    void backById(Long id);
}
