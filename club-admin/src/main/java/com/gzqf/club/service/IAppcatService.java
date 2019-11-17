package com.gzqf.club.service;

import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.BaseService;

import java.util.List;

public interface IAppcatService extends BaseService<Appcat> {
    List<Appcat> queryChildrenAppcat(Long id);
}
