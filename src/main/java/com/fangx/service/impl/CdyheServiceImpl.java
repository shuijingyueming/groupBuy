package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyheMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhe;
import com.fangx.model.cdyheExample;
import com.fangx.model.cdyheExample.Criteria;
import com.fangx.service.CdyheService;
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
public class CdyheServiceImpl implements CdyheService {

    @Autowired
    private cdyheMapper yheMapper;

    @Override
    public cdyhe getByid(Integer id) {
        return yheMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdyhe yhe) {
        return yheMapper.updateByPrimaryKeySelective(yhe) > 0 ? true : false;
    }

    @Override
    public cdyhe insert(cdyhe yhe) {
        yheMapper.insertSelective(yhe);
        return yhe;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyhe yhe = new cdyhe();
        cdyheExample e1 = new cdyheExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYhe001In(list);
        }
        yheMapper.updateByExampleSelective(yhe, e1);
    }

    @Override
    public cdyhe selectByName(String name) {
        cdyheExample e1 = new cdyheExample();
        Criteria c = e1.createCriteria();
        c.andYhe002EqualTo(name);
        List<cdyhe> list = yheMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdyhe> serachAll(String name) {
        cdyheExample e1 = new cdyheExample();
        Criteria c = e1.createCriteria();
        if(name!=null&&!name.isEmpty()) c.andYhe002Like("%"+name+"%");
        e1.setOrderByClause("yhe001 desc");
        return yheMapper.selectByExample1(e1);
    }

    @Override
    public void delete(Integer id) {
        yheMapper.deleteByPrimaryKey(id);
    }


    @Override
    public boolean saveBatch(Collection<cdyhe> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyhe> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyhe> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyhe entity) {
        return false;
    }

    @Override
    public cdyhe getOne(Wrapper<cdyhe> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyhe> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyhe> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyhe> getBaseMapper() {
        return null;
    }
}
