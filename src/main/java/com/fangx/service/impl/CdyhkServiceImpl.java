package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyhkMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhk;
import com.fangx.model.cdyhkExample;
import com.fangx.model.cdyhkExample.Criteria;
import com.fangx.service.CdyhkService;
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
public class CdyhkServiceImpl implements CdyhkService {
    @Autowired
    private cdyhkMapper yhkMapper;

    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public cdyhk getByid(String id) {
        return yhkMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) throws ParseException {
        cdyhkExample e1 = new cdyhkExample();
        Criteria c = e1.createCriteria();
//        if(pb.getOthersql()!=null) c.andYhk007Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql()!=null)c.andSql("(DATE_FORMAT(yhk003,'%Y-%m')='"+pb.getOthersql()+"')");
        if(pb.getOthersql2()!=null) c.andYhk002EqualTo(Integer.valueOf(pb.getOthersql2()));
        if(pb.getOthersql5()!=null) c.andYhk003GreaterThanOrEqualTo(sf.parse(pb.getOthersql5()+" 00:00:00"));
        if(pb.getOthersql6()!=null) c.andYhk003LessThanOrEqualTo(sf.parse(pb.getOthersql6()+" 23:59:59"));
        e1.setOrderByClause("yhk003 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdyhk yhk) {
        return yhkMapper.updateByPrimaryKeySelective(yhk) > 0 ? true : false;
    }

    @Override
    public cdyhk insert(cdyhk yhk) {
        yhkMapper.insertSelective(yhk);
        return yhk;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyhk yhk = new cdyhk();
        cdyhkExample e1 = new cdyhkExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYhk001In(list);
        }
        yhkMapper.updateByExampleSelective(yhk, e1);
    }

    @Override
    public cdyhk selectByName(Integer name) {
        cdyhkExample e1 = new cdyhkExample();
        Criteria c = e1.createCriteria();
        c.andYhk002EqualTo(name);
        List<cdyhk> list = yhkMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdyhk selectBycurentday(Date time, Integer gsid) throws ParseException {
        cdyhkExample e1 = new cdyhkExample();
        Criteria c = e1.createCriteria();
        if(gsid!=null) c.andYhk002EqualTo(gsid);
        c.andYhk003GreaterThanOrEqualTo(sf.parse(sf1.format(time)+" 00:00:00"));
        c.andYhk003LessThanOrEqualTo(sf.parse(sf1.format(time)+" 23:59:59"));
        List<cdyhk> list = yhkMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public PageBean queryByPage(PageBean pageBean, cdyhkExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yhkMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdyhk> list = yhkMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdyhk> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyhk> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyhk> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyhk entity) {
        return false;
    }

    @Override
    public cdyhk getOne(Wrapper<cdyhk> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyhk> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyhk> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyhk> getBaseMapper() {
        return null;
    }
}
