package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusbMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusb;
import com.fangx.model.cdusbExample;
import com.fangx.model.cdusbExample.Criteria;
import com.fangx.model.cdyhbExample;
import com.fangx.service.CdusbService;
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
public class CdusbServiceImpl implements CdusbService {

    @Autowired
    private cdusbMapper usbMapper;

    @Override
    public cdusb getByid(Integer id) {
        return usbMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsb002Like("%"+pb.getOthersql()+"%");
        e1.setOrderByClause("usb003 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdusb usb) {
        return usbMapper.updateByPrimaryKeySelective(usb) > 0 ? true : false;
    }

    @Override
    public cdusb insert(cdusb usb) {
        usbMapper.insertSelective(usb);
        return usb;
    }

    @Override
    public cdusb selectByName(String name) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        c.andUsb002EqualTo(name);
        List<cdusb> list = usbMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdusb> serachAll() {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        e1.setOrderByClause("usb003");
        return usbMapper.selectByExample(e1);
    }

    @Override
    public cdusb selectByweek(Integer gsid, Integer d) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        c.andUsb003GreaterThan(d +1);
        cdyhbExample e2 = new cdyhbExample();
        cdyhbExample.Criteria c1 = e2.createCriteria();
        if(gsid!=null)c1.andYhb003EqualTo(gsid);
        e1.setOrderByClause("usb003");
        List<cdusb> list = usbMapper.selectByExamplegs(e1,e2);
        return list.size() > 0 ? list.get(0) : null;
    }
    @Override
    public cdusb selectByweek1(Integer gsid,Integer d) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        c.andUsb003LessThan(d);
        cdyhbExample e2 = new cdyhbExample();
        cdyhbExample.Criteria c1 = e2.createCriteria();
        if(gsid!=null)c1.andYhb003EqualTo(gsid);
        e1.setOrderByClause("usb003");
        List<cdusb> list = usbMapper.selectByExamplegs(e1,e2);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdusb selectByweek2(Integer d) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        c.andUsb003EqualTo(d);
        List<cdusb> list = usbMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public cdusb selectByzq(Integer i) {
        cdusbExample e1 = new cdusbExample();
        Criteria c = e1.createCriteria();
        c.andUsb003EqualTo(i);
        List<cdusb> list = usbMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    public PageBean queryByPage(PageBean pageBean, cdusbExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) usbMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdusb> list = usbMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdusb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusb> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusb entity) {
        return false;
    }

    @Override
    public cdusb getOne(Wrapper<cdusb> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusb> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusb> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusb> getBaseMapper() {
        return null;
    }
}
