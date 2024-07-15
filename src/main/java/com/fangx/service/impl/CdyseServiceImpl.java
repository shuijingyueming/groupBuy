package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyseMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusdExample;
import com.fangx.model.cdyse;
import com.fangx.model.cdyseExample;
import com.fangx.model.cdyseExample.Criteria;
import com.fangx.service.CdyseService;
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
public class CdyseServiceImpl implements CdyseService {
    @Autowired
    private cdyseMapper yseMapper;

    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public cdyse getByid(String id) {
        return yseMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) throws ParseException {
        cdyseExample e1 = new cdyseExample();
        Criteria c = e1.createCriteria();
//        if(pb.getOthersql()!=null) c.andyse007Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql2()!=null)c.andSql("(DATE_FORMAT(yse003,'%Y-%m-%d')='"+pb.getOthersql2()+"')");
        cdusdExample e2 = new cdusdExample();
        cdusdExample.Criteria c1 = e2.createCriteria();
        if(pb.getOthersql()!=null) c1.andUsd002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql1()!=null) c1.andUsd004Like("%"+pb.getOthersql1()+"%");
        e1.setOrderByClause("yse003 desc");
        return queryByPage(pb, e1,e2);
    }

    @Override
    public boolean update(cdyse yse) {
        return yseMapper.updateByPrimaryKeySelective(yse) > 0 ? true : false;
    }

    @Override
    public cdyse insert(cdyse yse) {
        yseMapper.insertSelective(yse);
        return yse;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyse yse = new cdyse();
        cdyseExample e1 = new cdyseExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYse001In(list);
        }
        yseMapper.updateByExampleSelective(yse, e1);
    }

    @Override
    public cdyse selectByName(Integer name) {
        cdyseExample e1 = new cdyseExample();
        Criteria c = e1.createCriteria();
        c.andYse002EqualTo(name);
        List<cdyse> list = yseMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdyse selectBycurentday(Date time, Integer gsid) throws ParseException {
        cdyseExample e1 = new cdyseExample();
        Criteria c = e1.createCriteria();
        if(gsid!=null) c.andYse002EqualTo(gsid);
        c.andYse003GreaterThanOrEqualTo(sf.parse(sf1.format(time)+" 00:00:00"));
        c.andYse003LessThanOrEqualTo(sf.parse(sf1.format(time)+" 23:59:59"));
        List<cdyse> list = yseMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdyse selectByDS(String date, Integer gsid) {
        cdyseExample e1 = new cdyseExample();
        Criteria c = e1.createCriteria();
        c.andYse002EqualTo(gsid);
        c.andSql("(DATE_FORMAT(yse003,'%Y-%m-%d')='"+date+"')");
        List<cdyse> list = yseMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public PageBean queryByPage(PageBean pageBean, cdyseExample e1, cdusdExample e2) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yseMapper.countByExample1(e1,e2);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdyse> list = yseMapper.selectByExampleAndPage1(e1,e2, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdyse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyse> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyse entity) {
        return false;
    }

    @Override
    public cdyse getOne(Wrapper<cdyse> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyse> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyse> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyse> getBaseMapper() {
        return null;
    }
}
