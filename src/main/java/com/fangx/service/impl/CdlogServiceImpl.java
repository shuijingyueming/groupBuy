package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdlogMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdlog;
import com.fangx.model.cdlogExample;
import com.fangx.model.cdlogExample.Criteria;
import com.fangx.service.CdlogService;
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
public class CdlogServiceImpl implements CdlogService {
    @Autowired
    private cdlogMapper logMapper;

    @Override
    public boolean saveBatch(Collection<cdlog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdlog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdlog> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdlog entity) {
        return false;
    }

    @Override
    public cdlog getOne(Wrapper<cdlog> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdlog> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdlog> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdlog> getBaseMapper() {
        return null;
    }

    @Override
    public void insert(cdlog log) {
        logMapper.insert(log);
    }

    @Override
    public void deleteByTime(Date date) {
        cdlogExample xe = new cdlogExample();
        Criteria c = xe.createCriteria();
        c.andLog003LessThanOrEqualTo(date);
        logMapper.deleteByExample(xe);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cdlogExample e1 = new cdlogExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null)c.andLog003GreaterThanOrEqualTo(sdf.parse(pb.getOthersql().split(" - ")[0]+" 00:00:00"));
        if(pb.getOthersql()!=null)c.andLog003LessThanOrEqualTo(sdf.parse(pb.getOthersql().split(" - ")[1]+" 23:59:59"));
        /* if(pb.getOthersql2()!=null)c.andLog005EqualTo(pb.getOthersql2());*/
        if(pb.getOthersql3()!=null)c.andLog002Like("%"+pb.getOthersql3()+"%");
        e1.setOrderByClause("LOG003 desc");//按照日志时间倒序查询
        pb = queryByPage(pb,e1);
        return pb;
    }

    @Override
    public void deleteById(String id) {
        cdlogExample e1 = new cdlogExample();
        cdlogExample.Criteria c = e1.createCriteria();
        if(id!=null&&!id.isEmpty()){
            String[] ids=id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>)(List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andLog001In(list);
        }
        logMapper.deleteByExample(e1);
    }

    public PageBean queryByPage(PageBean pageBean, cdlogExample example) {
        int page = (int) pageBean.getCurrentPage();//本页页号
        int size = pageBean.getPageSize();//条数
        //record sum
        int sum = (int) logMapper.countByExample(example);
        //page count
        int count = sum%size==0 ? sum/size : sum/size+1;
        //check page
        page = page<1 ? 1 : ((page>count)? count : page);
        //query
        List list = logMapper.selectByExampleAndPage(example, new RowBounds((page-1)*size, size));
        pageBean.setResultList(list);
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setPageSize(size);
        return pageBean;
    }
}
