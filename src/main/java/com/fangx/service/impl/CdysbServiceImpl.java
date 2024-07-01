package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdysbMapper;
import com.fangx.model.*;
import com.fangx.model.cdysbExample.Criteria;
import com.fangx.service.CdysbService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
public class CdysbServiceImpl implements CdysbService {

    @Autowired
    private cdysbMapper ysbMapper;

    @Override
    public cdysb getByid(Integer id) {
        return ysbMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
//        if(pb.getOthersql()!=null) c.andYsb002EqualTo(Integer.valueOf(pb.getOthersql()));
        if(pb.getOthersql1()!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+pb.getOthersql1()+"')");
        if(pb.getOthersql2()!=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+pb.getOthersql2()+"')");
        e1.setOrderByClause("ysb003 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdysb ysb) {
        return ysbMapper.updateByPrimaryKeySelective(ysb) > 0 ? true : false;
    }

    @Override
    public cdysb insert(cdysb ysb) {
        ysbMapper.insertSelective(ysb);
        return ysb;
    }

    @Override
    public List<cdysb> serachAll() {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        e1.setOrderByClause("ysb003");
        return ysbMapper.selectByExample(e1);
    }

    @Override
    public List<cdysb> selectBygsid(Integer gsid) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb002EqualTo(gsid);
        e1.setOrderByClause("ysb003");
        return ysbMapper.selectByExample(e1);
    }

    @Override
    public cdysb selectBygsid(Integer gsid, String time) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb002EqualTo(gsid);
        c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public void delete(Integer id) {
        ysbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public cdysb selectBycpid(String time, String time2) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        if(time2!=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+time2+"')");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    public PageBean queryByPage(PageBean pageBean, cdysbExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) ysbMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdysb> list = ysbMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdysb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdysb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdysb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdysb entity) {
        return false;
    }

    @Override
    public cdysb getOne(Wrapper<cdysb> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdysb> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdysb> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdysb> getBaseMapper() {
        return null;
    }
}
