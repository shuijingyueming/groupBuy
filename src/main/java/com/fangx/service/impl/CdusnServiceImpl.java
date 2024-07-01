package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusnMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusn;
import com.fangx.model.cdusnExample;
import com.fangx.model.cdusnExample.Criteria;
import com.fangx.service.CdusnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
@Service
public class CdusnServiceImpl implements CdusnService {

    @Autowired
    private cdusnMapper usnMapper;

    @Override
    public cdusn getByid(Integer id) {
        return usnMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdusn usn) {
        return usnMapper.updateByPrimaryKeySelective(usn) > 0 ? true : false;
    }

    @Override
    public cdusn insert(cdusn usn) {
        usnMapper.insertSelective(usn);
        return usn;
    }

    @Override
    public void deleteById(List<String> list) {
        cdusnExample e1 = new cdusnExample();
        Criteria c = e1.createCriteria();
        c.andUsn003In(list);
        usnMapper.deleteByExample(e1);
    }


    @Override
    public List<cdusn> serachAll(Integer cpid) {
        cdusnExample e1 = new cdusnExample();
        Criteria c = e1.createCriteria();
        c.andUsn002EqualTo(cpid);
        e1.setOrderByClause("usn001 desc");
        return usnMapper.selectByExample(e1);
    }

    @Override
    public void deletebyid(Integer cpid) {
        cdusnExample e1 = new cdusnExample();
        Criteria c = e1.createCriteria();
        c.andUsn002EqualTo(cpid);
        e1.setOrderByClause("usn001 desc");
       usnMapper.deleteByExample(e1);
    }

    @Override
    public void delete(Integer id) {
        usnMapper.deleteByPrimaryKey(id);
    }


    @Override
    public boolean saveBatch(Collection<cdusn> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusn> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusn> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusn entity) {
        return false;
    }

    @Override
    public cdusn getOne(Wrapper<cdusn> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusn> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusn> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusn> getBaseMapper() {
        return null;
    }
}
