package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiApplianceDao extends BaseDao<Appliance> {
    void useById(@Param("memberId")Long memberId, @Param("id")Long id);

    void backById(@Param("id")Long id);

}
