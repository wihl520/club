package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Tips;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipsDao {

    List<Tips> getTipsList(Long id);

    Tips getTip(Long id);
}
