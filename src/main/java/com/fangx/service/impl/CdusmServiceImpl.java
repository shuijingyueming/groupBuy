package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusmMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusm;
import com.fangx.model.cdusmExample;
import com.fangx.model.cdusmExample.Criteria;
import com.fangx.service.CdusmService;
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
public class CdusmServiceImpl implements CdusmService {

    @Autowired
    private cdusmMapper usmMapper;

    @Override
    public cdusm getByid(Integer id) {
        return usmMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdusmExample e1 = new cdusmExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsm002Like("%"+pb.getOthersql()+"%");
        e1.setOrderByClause("usm001 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdusm usm) {
        return usmMapper.updateByPrimaryKeySelective(usm) > 0 ? true : false;
    }

    @Override
    public cdusm insert(cdusm usm) {
        usmMapper.insertSelective(usm);
        return usm;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdusm usm = new cdusm();
        cdusmExample e1 = new cdusmExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsm001In(list);
        }
        usmMapper.updateByExampleSelective(usm, e1);
    }

    @Override
    public cdusm selectByName(String name) {
        cdusmExample e1 = new cdusmExample();
        Criteria c = e1.createCriteria();
        c.andUsm002EqualTo(name);
        List<cdusm> list = usmMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdusm> serachAll() {
        return usmMapper.selectByExample(null);
    }

    @Override
    public void delete(Integer id) {
        usmMapper.deleteByPrimaryKey(id);
    }

    public PageBean queryByPage(PageBean pageBean, cdusmExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) usmMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdusm> list = usmMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdusm> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusm> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusm> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusm entity) {
        return false;
    }

    @Override
    public cdusm getOne(Wrapper<cdusm> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusm> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusm> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusm> getBaseMapper() {
        return null;
    }
}
