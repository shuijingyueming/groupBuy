package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdushMapper;
import com.fangx.model.cdush;
import com.fangx.model.cdushExample;
import com.fangx.model.cdushExample.Criteria;
import com.fangx.service.CdushService;
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
public class CdushServiceImpl implements CdushService {

    @Autowired
    private cdushMapper ushMapper;

    @Override
    public cdush getByid(String id) {
        return ushMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdush ush) {
        return ushMapper.updateByPrimaryKeySelective(ush) > 0 ? true : false;
    }

    @Override
    public cdush insert(cdush ush) {
        ushMapper.insertSelective(ush);
        return ush;
    }

    @Override
    public void deleteById(String id) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsh001In(list);
        }
        ushMapper.deleteByExample(e1);
    }


    @Override
    public List<cdush> serachAll(String cpid) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002EqualTo(cpid);
        e1.setOrderByClause("ush001 desc");
        return ushMapper.selectByExample(e1);
    }

    @Override
    public void deletebyid(String cpid) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002EqualTo(cpid);
        e1.setOrderByClause("ush001 desc");
       ushMapper.deleteByExample(e1);
    }

    @Override
    public void delete(String id) {
        ushMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<cdush> selectByyhid(Integer yhid) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002IsNull();
        c.andUsh007EqualTo(yhid);
        return ushMapper.selectByExample1(e1);
    }

    @Override
    public List<cdush> selectByyhidjs(Integer yhid, String id) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002IsNull();
        c.andUsh007EqualTo(yhid);
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsh001In(list);
        }
        return ushMapper.selectByExample1(e1);
    }

    @Override
    public cdush selectByyhcp(Integer yhid, Integer cpid) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002IsNull();
        c.andUsh003EqualTo(cpid);
        c.andUsh007EqualTo(yhid);
        List<cdush> list=ushMapper.selectByExample(e1);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<cdush> selectByyhidtk(String ddid) {
        cdushExample e1 = new cdushExample();
        Criteria c = e1.createCriteria();
        c.andUsh002EqualTo(ddid);
        return ushMapper.selectByExample1(e1);
    }


    @Override
    public boolean saveBatch(Collection<cdush> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdush> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdush> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdush entity) {
        return false;
    }

    @Override
    public cdush getOne(Wrapper<cdush> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdush> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdush> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdush> getBaseMapper() {
        return null;
    }
}
