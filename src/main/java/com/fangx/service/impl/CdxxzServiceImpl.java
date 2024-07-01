package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdxxzMapper;
import com.fangx.model.cdxxz;
import com.fangx.model.cdxxzExample;
import com.fangx.model.cdxxzWithBLOBs;
import com.fangx.service.CdxxzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
public class CdxxzServiceImpl implements CdxxzService {
    @Autowired
    public cdxxzMapper xxzMapper;

    @Override
    public boolean saveBatch(Collection<cdxxz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdxxz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdxxz> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdxxz entity) {
        return false;
    }

    @Override
    public cdxxz getOne(Wrapper<cdxxz> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdxxz> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdxxz> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdxxz> getBaseMapper() {
        return null;
    }

    @Override
    public cdxxzWithBLOBs selGetAll() {
        cdxxzExample e1= new cdxxzExample();
        cdxxzExample.Criteria c = e1.createCriteria();
        c.andXxz001EqualTo(1);
        e1.setOrderByClause("xxz001 desc");
        List<cdxxzWithBLOBs> list = xxzMapper.selectByExampleWithBLOBs(e1);
        return list!=null&&list.size()>0?list.get(0):this.insert();
    }

    @Override
    public cdxxzWithBLOBs insert() {
        cdxxzWithBLOBs xxz=new cdxxzWithBLOBs();
        xxz.setXxz001(1);
        xxz.setXxz014(1);
        xxzMapper.insert(xxz);
        return xxz;
    }

    @Override
    public void update(cdxxzWithBLOBs xxz) {
        xxzMapper.updateByPrimaryKeySelective(xxz);
    }

    @Override
    public cdxxzWithBLOBs insert1() {
        cdxxzWithBLOBs xxz=new cdxxzWithBLOBs();
        xxz.setXxz001(2);
        xxz.setXxz008("N");
        xxzMapper.insert(xxz);
        return xxz;
    }

    @Override
    public cdxxzWithBLOBs selectByid(Integer id) {
        cdxxzExample e1= new cdxxzExample();
        cdxxzExample.Criteria c = e1.createCriteria();
        c.andXxz001EqualTo(id);
        e1.setOrderByClause("xxz001 desc");
        List<cdxxzWithBLOBs> list = xxzMapper.selectByExampleWithBLOBs(e1);
        return list!=null&&list.size()>0?list.get(0):this.insert1();
    }
}
