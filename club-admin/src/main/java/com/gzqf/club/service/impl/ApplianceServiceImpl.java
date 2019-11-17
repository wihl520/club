package com.gzqf.club.service.impl;

import com.gzqf.club.dao.IAppcatDao;
import com.gzqf.club.dao.IApplianceDao;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.ApplianceAdmin;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.IApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplianceServiceImpl extends BaseServiceImpl<ApplianceAdmin, IApplianceDao> implements IApplianceService {
   @Autowired
    private IAppcatDao appcatDao;

    @Override
    //设定所属类为父类
    public Result save(ApplianceAdmin applianceAdmin) {
        appcatDao.setIsParentTrue(applianceAdmin.getParent().getId());
        Result result = super.save(applianceAdmin);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            result.setMessage("数据更新成功！");
        }
        return result;
    }

    @Override
    public Result update(ApplianceAdmin applianceAdmin) {
        //查询出原来的对象
        ApplianceAdmin preApplianceAdmin = dao.getById(applianceAdmin.getId());
        //将添加对象的父对象设置为父节点
        appcatDao.setIsParentTrue(applianceAdmin.getParent().getId());
        //更新现在对象的数据
        Result result = super.update(applianceAdmin);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            result.setMessage("数据更新成功！");
        }
        List<Appcat> list = appcatDao.queryChildrenAppcat(preApplianceAdmin.getParent().getId());
        if(list.isEmpty()){
            appcatDao.setIsParentFalse(preApplianceAdmin.getParent().getId());
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        ApplianceAdmin preApplianceAdmin = dao.getById(id);
        Result result = super.delete(id);
        List<Appcat> childrenList = appcatDao.queryChildrenAppcat(preApplianceAdmin.getParent().getId());
        if(childrenList.isEmpty()){
            appcatDao.setIsParentFalse(preApplianceAdmin.getParent().getId());
        }
        return result;
    }
}
