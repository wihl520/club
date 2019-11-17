package com.gzqf.webui.service;

import com.gzqf.club.entity.Tips;

import java.util.List;

public interface UiTipsService {
    /**
     * 得到贴士信息的集合
     */
    List<Tips> getTipsList(Long id);

    /**
     * 展示单个贴士信息
     */
    Tips getTip(Long id);
}
