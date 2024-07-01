package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdysaMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdysa;
import com.fangx.model.cdysaExample;
import com.fangx.model.cdysaExample.Criteria;
import com.fangx.service.CdysaService;
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
public class CdysaServiceImpl implements CdysaService {

    @Autowired
    private cdysaMapper ysaMapper;

    @Override
    public cdysa getByid(Integer id) {
        return ysaMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdysa ysa) {
        return ysaMapper.updateByPrimaryKeySelective(ysa) > 0 ? true : false;
    }

    @Override
    public cdysa insert(cdysa ysa) {
        ysaMapper.insertSelective(ysa);
        return ysa;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdysa ysa = new cdysa();
        cdysaExample e1 = new cdysaExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYsa001In(list);
        }
        ysaMapper.updateByExampleSelective(ysa, e1);
    }

    @Override
    public cdysa selectByName(String name) {
        cdysaExample e1 = new cdysaExample();
        Criteria c = e1.createCriteria();
        c.andYsa002EqualTo(name);
        List<cdysa> list = ysaMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdysa> serachAll(String name) {
        cdysaExample e1 = new cdysaExample();
        Criteria c = e1.createCriteria();
        if(name!=null&&!name.isEmpty()) c.andYsa002Like("%"+name+"%");
        e1.setOrderByClause("ysa001 desc");
        return ysaMapper.selectByExample(e1);
    }

    @Override
    public void delete(Integer id) {
        ysaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<cdysa> selectBysjid(Integer id) {
        cdysaExample e1 = new cdysaExample();
        Criteria c = e1.createCriteria();
        if(id!=null) c.andYsa003EqualTo(id);
        e1.setOrderByClause("ysa001 desc");
        return ysaMapper.selectByExample(e1);
    }


    @Override
    public boolean saveBatch(Collection<cdysa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdysa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdysa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdysa entity) {
        return false;
    }

    @Override
    public cdysa getOne(Wrapper<cdysa> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdysa> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdysa> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdysa> getBaseMapper() {
        return null;
    }
}
