package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyhbMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhb;
import com.fangx.model.cdyhbExample;
import com.fangx.model.cdyhbExample.Criteria;
import com.fangx.service.CdyhbService;
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
public class CdyhbServiceImpl implements CdyhbService {

    @Autowired
    private cdyhbMapper yhbMapper;

    @Override
    public cdyhb getByid(String id) {
        return yhbMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdyhb yhb) {
        return yhbMapper.updateByPrimaryKeySelective(yhb) > 0 ? true : false;
    }

    @Override
    public cdyhb insert(cdyhb yhb) {
        yhbMapper.insertSelective(yhb);
        return yhb;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyhb yhb = new cdyhb();
        cdyhbExample e1 = new cdyhbExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYhb001In(list);
        }
        yhbMapper.updateByExampleSelective(yhb, e1);
    }


    @Override
    public List<cdyhb> serachAll(Integer cpid) {
        cdyhbExample e1 = new cdyhbExample();
        Criteria c = e1.createCriteria();
        c.andYhb002EqualTo(cpid);
        e1.setOrderByClause("yhb001 desc");
        return yhbMapper.selectByExample(e1);
    }

    @Override
    public void deletebyid(Integer cpid) {
        cdyhbExample e1 = new cdyhbExample();
        Criteria c = e1.createCriteria();
        c.andYhb003EqualTo(cpid);
        e1.setOrderByClause("yhb001 desc");
       yhbMapper.deleteByExample(e1);
    }

    @Override
    public void delete(String id) {
        yhbMapper.deleteByPrimaryKey(id);
    }


    @Override
    public boolean saveBatch(Collection<cdyhb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyhb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyhb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyhb entity) {
        return false;
    }

    @Override
    public cdyhb getOne(Wrapper<cdyhb> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyhb> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyhb> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyhb> getBaseMapper() {
        return null;
    }
}
