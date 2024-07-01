package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyhaMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyha;
import com.fangx.model.cdyhaExample;
import com.fangx.model.cdyhaExample.Criteria;
import com.fangx.service.CdyhaService;
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
public class CdyhaServiceImpl implements CdyhaService {

    @Autowired
    private cdyhaMapper yhaMapper;

    @Override
    public cdyha getByid(Integer id) {
        return yhaMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdyha yha) {
        return yhaMapper.updateByPrimaryKeySelective(yha) > 0 ? true : false;
    }

    @Override
    public cdyha insert(cdyha yha) {
        yhaMapper.insertSelective(yha);
        return yha;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyha yha = new cdyha();
        cdyhaExample e1 = new cdyhaExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYha001In(list);
        }
        yhaMapper.updateByExampleSelective(yha, e1);
    }


    @Override
    public List<cdyha> serachAll(Integer cpid) {
        cdyhaExample e1 = new cdyhaExample();
        Criteria c = e1.createCriteria();
        c.andYha002EqualTo(cpid);
        e1.setOrderByClause("yha001 desc");
        return yhaMapper.selectByExample(e1);
    }

    @Override
    public void deletebyid(Integer cpid) {
        cdyhaExample e1 = new cdyhaExample();
        Criteria c = e1.createCriteria();
        c.andYha002EqualTo(cpid);
       yhaMapper.deleteByExample(e1);
    }

    @Override
    public void deleteByqsid(Integer qsid) {
        cdyhaExample e1 = new cdyhaExample();
        Criteria c = e1.createCriteria();
        c.andYha003EqualTo(qsid);
        yhaMapper.deleteByExample(e1);
    }

    @Override
    public void delete(Integer id) {
        yhaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public cdyha getByqscp(Integer qsid, Integer id) {
        return yhaMapper.selectByqscp(qsid,id);
    }


    @Override
    public boolean saveBatch(Collection<cdyha> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyha> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyha> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyha entity) {
        return false;
    }

    @Override
    public cdyha getOne(Wrapper<cdyha> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyha> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyha> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyha> getBaseMapper() {
        return null;
    }
}
