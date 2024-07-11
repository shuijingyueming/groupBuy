package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusdMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusd;
import com.fangx.model.cdusdExample;
import com.fangx.model.cdusdExample.Criteria;
import com.fangx.model.cdyhbExample;
import com.fangx.service.CdusdService;
import org.apache.ibatis.session.RowBounds;
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
public class CdusdServiceImpl implements CdusdService {

    @Autowired
    private cdusdMapper usdMapper;

    @Override
    public cdusd getByid(Integer id) {
        return usdMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdusdExample e1 = new cdusdExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsd002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql1()!=null) c.andUsd004Like("%"+pb.getOthersql1()+"%");
        e1.setOrderByClause("usd001 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdusd usd) {
        return usdMapper.updateByPrimaryKeySelective(usd) > 0 ? true : false;
    }

    @Override
    public cdusd insert(cdusd usd) {
        usdMapper.insertSelective(usd);
        return usd;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdusd usd = new cdusd();
        cdusdExample e1 = new cdusdExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsd001In(list);
        }
        usdMapper.updateByExampleSelective(usd, e1);
    }

    @Override
    public cdusd selectByName(String name) {
        cdusdExample e1 = new cdusdExample();
        Criteria c = e1.createCriteria();
        c.andUsd002EqualTo(name);
        List<cdusd> list = usdMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdusd> serachAll() {
        return usdMapper.selectByExample(null);
    }

    @Override
    public List<cdusd> serachBytime(Integer weekDay) {
        cdusdExample e1 = new cdusdExample();
        Criteria c = e1.createCriteria();
        cdyhbExample e2 = new cdyhbExample();
        cdyhbExample.Criteria c1 = e2.createCriteria();
        c1.andYhb002EqualTo(weekDay);
        return usdMapper.selectByExample1(e1,e2);
    }

    public PageBean queryByPage(PageBean pageBean, cdusdExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) usdMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdusd> list = usdMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdusd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusd entity) {
        return false;
    }

    @Override
    public cdusd getOne(Wrapper<cdusd> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusd> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusd> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusd> getBaseMapper() {
        return null;
    }
}
