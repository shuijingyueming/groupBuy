package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyhdMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhd;
import com.fangx.model.cdyhdExample;
import com.fangx.model.cdyhdExample.Criteria;
import com.fangx.service.CdyhdService;
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
public class CdyhdServiceImpl implements CdyhdService {

    @Autowired
    private cdyhdMapper yhdMapper;

    @Override
    public cdyhd getByid(String id) {
        return yhdMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdyhdExample e1 = new cdyhdExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql1()!=null) c.andYhd002EqualTo(Integer.valueOf(pb.getOthersql1()));
        if(pb.getOthersql2()!=null) c.andYhd003EqualTo(Integer.valueOf(pb.getOthersql2()));
        e1.setOrderByClause("yhd005 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdyhd yhd) {
        return yhdMapper.updateByPrimaryKeySelective(yhd) > 0 ? true : false;
    }

    @Override
    public cdyhd insert(cdyhd yhd) {
        yhdMapper.insertSelective(yhd);
        return yhd;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyhd yhd = new cdyhd();
        cdyhdExample e1 = new cdyhdExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYhd001In(list);
        }
        yhdMapper.updateByExampleSelective(yhd, e1);
    }

    @Override
    public  List<cdyhd> selectByyhid(Integer yhid) {
        cdyhdExample e1 = new cdyhdExample();
        Criteria c = e1.createCriteria();
        c.andYhd002EqualTo(yhid);
        List<cdyhd> list = yhdMapper.selectByExample(e1);
        return list;
    }

    public PageBean queryByPage(PageBean pageBean, cdyhdExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yhdMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdyhd> list = yhdMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdyhd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyhd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyhd> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyhd entity) {
        return false;
    }

    @Override
    public cdyhd getOne(Wrapper<cdyhd> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyhd> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyhd> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyhd> getBaseMapper() {
        return null;
    }
}
