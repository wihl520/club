package com.gzqf.club.service.impl;

import com.gzqf.club.dao.IAppcatDao;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.IAppcatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppcatServiceImpl extends BaseServiceImpl<Appcat, IAppcatDao> implements IAppcatService {
    @Override
    public List<Appcat> queryChildrenAppcat(Long id) {
        return dao.queryChildrenAppcat(id);
    }

    @Override
    public Result save(Appcat appcat) {
        //新增，其父节点必定为父节点
        dao.setIsParentTrue(appcat.getParent().getId());
        Result result = super.save(appcat);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            result.setMessage("数据更新成功！");
        }
        return result;
    }

    @Override
    public Result update(Appcat appcat) {
        //查询出原来的对象
        Appcat preAppcat = dao.getById(appcat.getId());
        //将添加对象的父对象设置为父节点
        dao.setIsParentTrue(appcat.getParent().getId());
        //更新现在对象的数据
        Result result = super.update(appcat);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            result.setMessage("数据更新成功！");
        }
        List<Appcat> list = dao.queryChildrenAppcat(preAppcat.getParent().getId());
        if(list.isEmpty()){
            dao.setIsParentFalse(preAppcat.getParent().getId());
        }
        return result;
    }

    @Override
    public Result delete(Long id) {
        Appcat preAppcat = dao.getById(id);
        if(preAppcat.getIsParent() ==1){
            return Result.fail("删除失败，不能删除带有子数据的数据！");
        }
        Result result = super.delete(id);
        List<Appcat> childrenList = dao.queryChildrenAppcat(preAppcat.getParent().getId());
        if(childrenList.isEmpty()){
            dao.setIsParentFalse(preAppcat.getParent().getId());
        }
        return result;
    }
}
