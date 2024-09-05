package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusgMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusg;
import com.fangx.model.cdusgExample;
import com.fangx.model.cdusgExample.Criteria;
import com.fangx.service.CdusgService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CdusgServiceImpl implements CdusgService {
    @Autowired
    private cdusgMapper usgMapper;

    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public cdusg getByid(String id) {
        return usgMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(cdusg usg) {
        return usgMapper.updateByPrimaryKeySelective(usg) > 0 ? true : false;
    }

    @Override
    public cdusg insert(cdusg usg) {
        usgMapper.insertSelective(usg);
        return usg;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdusg usg = new cdusg();
        cdusgExample e1 = new cdusgExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsg001In(list);
        }
        usgMapper.updateByExampleSelective(usg, e1);
    }

    @Override
    public cdusg selectByName(Integer name) {
        cdusgExample e1 = new cdusgExample();
        Criteria c = e1.createCriteria();
        c.andUsg003EqualTo(name);
        List<cdusg> list = usgMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void delete(String jgid) {
        usgMapper.deleteByPrimaryKey(jgid);
    }

    @Override
    public cdusg getBycpgs(Integer cpid, Integer gsid) {
        cdusgExample e1 = new cdusgExample();
        Criteria c = e1.createCriteria();
        c.andUsg002EqualTo(cpid);
        c.andUsg003EqualTo(gsid);
        List<cdusg> list = usgMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean saveBatch(Collection<cdusg> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusg> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusg> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusg entity) {
        return false;
    }

    @Override
    public cdusg getOne(Wrapper<cdusg> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusg> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusg> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusg> getBaseMapper() {
        return null;
    }
}
