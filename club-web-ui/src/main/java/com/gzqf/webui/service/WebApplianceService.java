package com.gzqf.webui.service;

import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;

public interface WebApplianceService {
    Result<PageResult<Appliance>> getAllApplianceInfo(Page page, String categoryId);
    void userById(String id, String memberId);

    void backById(String id);
}
