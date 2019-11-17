package com.gzqf.club.persistence;


import com.gzqf.club.utils.BeanValidator;
import com.gzqf.club.web.support.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <p>Description: </p>
 * service抽象 ，实现BaseService接口(需要传入泛型的实体类)
 * 相当于Service接口由ServiceImpl实现
 * 方法对象用来接收（泛型的）实体类，还有（泛型的）Dao层方法
 *
 * @param <T> 所有实体继承对象
 * @param <D> 所有实体继承Dao
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 15:40
 **/
public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDao> implements BaseService<T> {

    /**
     * 使用日志框架
     */
    private static final Logger logger = Logger.getLogger(BaseServiceImpl.class);

    @Autowired
    protected D dao;

    @Override
    public Result save(T t) {
        try {
            Date date = new Date();
            t.setUpdated(date);
            t.setCreated(date);
            dao.save(t);
            return Result.success("", t);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            dao.delete(id);
            return Result.success("", id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result update(T t) {
        try {
            String message = BeanValidator.validator(t);
            if (StringUtils.isNotBlank(message)) {
                return Result.fail(message);
            }
            /*要添加修改的时间*/
            t.setUpdated(new Date());
            dao.update(t);
            return Result.success("", t);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result findList(T t) {
        try {
            List list = dao.findList(t);
            return Result.success("", list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * current  当前第几页
     * pageSize 每页多少条
     *
     * @return 响应的信息
     */
    @Override
    public Result pageList(T user) {
        //总条数
        long count = dao.findListCount(user);
        //执行分页查询
        List<T> userList = dao.findList(user);
        //将查询结果、总条数、当前页数等数据放到pageResult对象中
        Result result = getResult(user, count, userList);
        return result;
    }

    /**
     * @param id 通过id查询用户
     * @return 实体对象数据
     */
    @Override
    public T getById(Long id) {
        /* 因为BaseDao中是泛型，继承BaseEntity,所以还不知道是什么实体类，但是必定是BaseEntity的子类，所以要强转 */
        return (T) dao.getById(id);
    }

    /**
     * 查询实体对象数据返回
     *
     * @param user     实体对象
     * @param count    总条数
     * @param userList 数据集
     * @return 处理响应
     */
    protected Result getResult(T user, long count, List<T> userList) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCount(count);
        pageResult.setPageSize(user.getPage().getPageSize());
        pageResult.setCurrent(user.getPage().getCurrent());
        pageResult.setList(userList);
        Result result = new Result();
        result.setData(pageResult);
        return result;
    }
}
