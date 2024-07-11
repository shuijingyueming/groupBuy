package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdysdMapper;
import com.fangx.model.cdysd;
import com.fangx.model.cdysdExample;
import com.fangx.model.cdysdExample.Criteria;
import com.fangx.service.CdysdService;
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
public class CdysdServiceImpl implements CdysdService {

    @Autowired
    private cdysdMapper ysdMapper;

    @Override
    public cdysd getByid(Integer id) {
        return ysdMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdysd ysd) {
        return ysdMapper.updateByPrimaryKeySelective(ysd) > 0 ? true : false;
    }

    @Override
    public cdysd insert(cdysd ysd) {
        ysdMapper.insertSelective(ysd);
        return ysd;
    }

    @Override
    public void deleteById(String id) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYsd001In(list);
        }
        ysdMapper.deleteByExample(e1);
    }


    @Override
    public List<cdysd> serachAll(Integer cpid) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        c.andYsd002EqualTo(cpid);
        e1.setOrderByClause("ysd001 desc");
        return ysdMapper.selectByExample(e1);
    }

    @Override
    public void deletebyid(Integer cpid) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        c.andYsd002EqualTo(cpid);
        e1.setOrderByClause("ysd001 desc");
       ysdMapper.deleteByExample(e1);
    }

    @Override
    public void delete(Integer id) {
        ysdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<cdysd> selectByyhid(Integer yhid) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        c.andYsd002EqualTo(yhid);
        return ysdMapper.selectByExample(e1);
    }

    @Override
    public List<cdysd> selectByyhidjs(Integer yhid, String id) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        c.andYsd002EqualTo(yhid);
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYsd001In(list);
        }
        return ysdMapper.selectByExample(e1);
    }

    @Override
    public cdysd selectByyhcp(Integer yhid, Integer cpid) {
        cdysdExample e1 = new cdysdExample();
        Criteria c = e1.createCriteria();
        c.andYsd002EqualTo(cpid);
        c.andYsd003EqualTo(yhid);
        List<cdysd> list=ysdMapper.selectByExample(e1);
        return list.size()>0?list.get(0):null;
    }


    @Override
    public boolean saveBatch(Collection<cdysd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdysd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdysd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdysd entity) {
        return false;
    }

    @Override
    public cdysd getOne(Wrapper<cdysd> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdysd> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdysd> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdysd> getBaseMapper() {
        return null;
    }
}
