package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusaMapper;
import com.fangx.model.*;
import com.fangx.model.cdusaExample.Criteria;
import com.fangx.service.CdusaService;
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
public class CdusaServiceImpl implements CdusaService {
    @Autowired
    private cdusaMapper usaMapper;

    @Override
    public boolean saveBatch(Collection<cdusa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusa> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusa entity) {
        return false;
    }

    @Override
    public cdusa getOne(Wrapper<cdusa> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusa> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusa> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusa> getBaseMapper() {
        return null;
    }

    @Override
    public List<cdusa> serachAll() {
        return usaMapper.selectByExample(null);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdusaExample e1 = new cdusaExample();
        Criteria c = e1.createCriteria();
        c.andUsa002NotEqualTo("admin");
        if(pb.getOthersql()!=null) c.andUsa002Like("%"+pb.getOthersql()+"%");
        e1.setOrderByClause("USA001 desc");//倒序
        return queryByPage(pb,e1);
    }

    @Override
    public cdusa getByid(Integer id) {
        return usaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(cdusa usa) {
        usaMapper.updateByPrimaryKeySelective(usa);
    }

    @Override
    public cdusa insert(cdusa usa) {
        usaMapper.insertSelective(usa);
        return usa;
    }

    @Override
    public void deleteById(int id) {
        usaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteById(String id) {
        cdusaExample e1 = new cdusaExample();
        Criteria c = e1.createCriteria();
        if(id!=null&&!id.isEmpty()){
            String[] ids=id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>)(List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsa001In(list);
        }
        usaMapper.deleteByExample(e1);
    }

    public PageBean queryByPage(PageBean pageBean, cdusaExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) usaMapper.countByExample(example);
        //page count
        int count = sum%size==0 ? sum/size : sum/size+1;
        //check page
        page = page<1 ? 1 : ((page>count)? count : page);
        //query
        List<cduse> list = usaMapper.selectByExampleAndPage(example, new RowBounds((page-1)*size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }
}
