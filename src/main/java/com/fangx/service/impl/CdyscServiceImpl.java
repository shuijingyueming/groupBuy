package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyscMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdysc;
import com.fangx.model.cdyscExample;
import com.fangx.model.cdyscExample.Criteria;
import com.fangx.service.CdyscService;
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
public class CdyscServiceImpl implements CdyscService {

    @Autowired
    private cdyscMapper yscMapper;

    @Override
    public cdysc getByid(Integer id) {
        return yscMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdyscExample e1 = new cdyscExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql1()!=null) c.andYsc002EqualTo(Integer.valueOf(pb.getOthersql1()));
        if(pb.getOthersql2()!=null)c.andSql("(DATE_FORMAT(ysc003,'%Y-%m-%d')='"+pb.getOthersql2()+"')");
        e1.setOrderByClause("ysc003 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdysc ysc) {
        return yscMapper.updateByPrimaryKeySelective(ysc) > 0 ? true : false;
    }

    @Override
    public cdysc insert(cdysc ysc) {
        yscMapper.insertSelective(ysc);
        return ysc;
    }

    @Override
    public List<cdysc> serachAll() {
        cdyscExample e1 = new cdyscExample();
        Criteria c = e1.createCriteria();
        e1.setOrderByClause("ysc003");
        return yscMapper.selectByExample(e1);
    }

    @Override
    public List<cdysc> selectBycp(Integer cpid, String date) {
        cdyscExample e1 = new cdyscExample();
        Criteria c = e1.createCriteria();
        c.andYsc002EqualTo(cpid);
        if(date!=null&&!date.isEmpty())c.andSql("(DATE_FORMAT(ysc003,'%Y-%m-%d')='"+date+"')");
        e1.setOrderByClause("ysc003");
        return yscMapper.selectByExample(e1);
    }

    @Override
    public cdysc selectBycpid(Integer cpid, String time) {
        cdyscExample e1 = new cdyscExample();
        Criteria c = e1.createCriteria();
        c.andYsc002EqualTo(cpid);
        c.andSql("(DATE_FORMAT(ysc003,'%Y-%m-%d')='"+time+"')");
        e1.setOrderByClause("ysc003");
        List<cdysc> list = yscMapper.selectByExample(e1);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public void delete(Integer id) {
        yscMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean selectBytime(String time) {
        cdyscExample e1 = new cdyscExample();
        Criteria c = e1.createCriteria();
        c.andSql("(DATE_FORMAT(ysc003,'%Y-%m-%d')='"+time+"')");
        e1.setOrderByClause("ysc003");
        List<cdysc>  list= yscMapper.selectByExample(e1);
        return list.size()>0;
    }

    public PageBean queryByPage(PageBean pageBean, cdyscExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yscMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdysc> list = yscMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdysc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdysc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdysc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdysc entity) {
        return false;
    }

    @Override
    public cdysc getOne(Wrapper<cdysc> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdysc> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdysc> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdysc> getBaseMapper() {
        return null;
    }
}
