package com.gzqf.clubapi.service;

import com.gzqf.club.entity.Tips;

import java.util.List;

public interface ApiTipsService {
    List<Tips> getTipsList(Long id);

    Tips getTip(Long id);
}
