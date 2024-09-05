package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cduscMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusc;
import com.fangx.model.cduscExample;
import com.fangx.model.cduscExample.Criteria;
import com.fangx.service.CduscService;
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
public class CduscServiceImpl implements CduscService {

    @Autowired
    private cduscMapper uscMapper;

    @Override
    public cdusc getByid(Integer id) {
        return uscMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsc002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql1()!=null) c.andUsc015Like("%"+pb.getOthersql1()+"%");
        if(pb.getOthersql2()!=null) c.andUsc005EqualTo(Integer.valueOf(pb.getOthersql2()));
        e1.setOrderByClause("usc001 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdusc usc) {
        return uscMapper.updateByPrimaryKeySelective(usc) > 0 ? true : false;
    }

    @Override
    public cdusc insert(cdusc usc) {
        uscMapper.insertSelective(usc);
        return usc;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdusc usc = new cdusc();
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsc001In(list);
        }
        uscMapper.updateByExampleSelective(usc, e1);
    }

    @Override
    public cdusc selectByName(String name) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        c.andUsc002EqualTo(name);
        List<cdusc> list = uscMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdusc> serachAll(Integer id) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andUsc005EqualTo(id);
        return uscMapper.selectByExample(e1);
    }

    @Override
    public cdusc selectByOpenid(String openid) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        c.andUsc004EqualTo(openid);
        c.andUsc003EqualTo("A");
        List<cdusc> list = uscMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdusc selectByPhone(String phone, String gsid) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        c.andUsc015EqualTo(phone);
        if(gsid!=null)c.andUsc005EqualTo(Integer.valueOf(gsid));
        List<cdusc> list = uscMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdusc selectBygsid(String name, String phone, Integer gsid) {
        cduscExample e1 = new cduscExample();
        Criteria c = e1.createCriteria();
        c.andUsc002EqualTo(name);
        c.andUsc005EqualTo(gsid);
        c.andUsc015EqualTo(phone);
        List<cdusc> list = uscMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public PageBean queryByPage(PageBean pageBean, cduscExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) uscMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdusc> list = uscMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdusc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusc entity) {
        return false;
    }

    @Override
    public cdusc getOne(Wrapper<cdusc> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusc> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusc> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusc> getBaseMapper() {
        return null;
    }
}
