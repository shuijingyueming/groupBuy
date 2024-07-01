package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cduseMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cduse;
import com.fangx.model.cduseExample;
import com.fangx.model.cduseExample.Criteria;
import com.fangx.service.CduseService;
import com.fangx.service.CduseService;
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
public class CduseServiceImpl implements CduseService {

    @Autowired
    private cduseMapper useMapper;

    @Override
    public cduse getLogin(String name, String pwd) {
        cduseExample cx = new cduseExample();
        Criteria c = cx.createCriteria();
        c.andUse002EqualTo(name);
        c.andUse003EqualTo(pwd);
        List<cduse> uselist = useMapper.selectByExample(cx);
        return uselist.size() > 0 ? uselist.get(0) : null;
    }

    @Override
    public cduse getByid(Integer id) {
        return useMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cduseExample e1 = new cduseExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUse002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql6()!=null) c.andUse007Like("%"+pb.getOthersql6()+"%");
        c.andUse002NotEqualTo("admin");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cduse use) {
        return useMapper.updateByPrimaryKeySelective(use) > 0 ? true : false;
    }

    @Override
    public cduse insert(cduse use) {
        useMapper.insertSelective(use);
        return use;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cduse use = new cduse();
        cduseExample e1 = new cduseExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUse001In(list);
        }
        c.andUse002NotEqualTo("admin");
        useMapper.updateByExampleSelective(use, e1);
    }

    @Override
    public cduse selectByName(String name) {
        cduseExample e1 = new cduseExample();
        Criteria c = e1.createCriteria();
        c.andUse002EqualTo(name);
        List<cduse> list = useMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public PageBean queryByPage(PageBean pageBean, cduseExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) useMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cduse> list = useMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cduse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cduse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cduse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cduse entity) {
        return false;
    }

    @Override
    public cduse getOne(Wrapper<cduse> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cduse> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cduse> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cduse> getBaseMapper() {
        return null;
    }
}
