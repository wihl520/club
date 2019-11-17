package com.gzqf.club.service.impl;

import com.gzqf.club.dao.MemBerDao;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.MemBerService;
import com.gzqf.club.utils.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class MemBerServiceImpl extends BaseServiceImpl<Member, MemBerDao> implements MemBerService {

    @Override
    @Transactional
    public Result save(Member member) {
        //先校验
        //如果BeanValidator.validator返回空，那么校验通过，否则校验不通过
        String message= BeanValidator.validator(member);
        //如果message不为空，是不是非法
        if(StringUtils.isNotBlank(message)){
            //Result.fail 失败
            return Result.fail(message);
        }

        //为什么要重写
        //因为我们加密码加密的逻辑
        if(StringUtils.isNotBlank(member.getPassword())){
            member.setPassword(DigestUtils.md5DigestAsHex(member.getPassword().getBytes()));
        }
        return super.save(member);
    }

    /**
     * 删除多个id
     *
     * @param ids
     */
    @Override
    @Transactional
    public void deleteMutil(List ids) {
        dao.deleteMutil(ids);
    }


}
