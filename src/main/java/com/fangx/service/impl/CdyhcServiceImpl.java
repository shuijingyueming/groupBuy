package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdyhcMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhc;
import com.fangx.model.cdyhcExample;
import com.fangx.model.cdyhcExample.Criteria;
import com.fangx.service.CdyhcService;
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
public class CdyhcServiceImpl implements CdyhcService {

    @Autowired
    private cdyhcMapper yhcMapper;

    protected final static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected final static SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");



    @Override
    public cdyhc getByid(String id) {
        return yhcMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andYhc012Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql6()!=null) c.andYhc002EqualTo(Integer.valueOf(pb.getOthersql6()));
        if(pb.getOthersql1()!=null) c.andYhc003EqualTo(Integer.valueOf(pb.getOthersql1()));
        if(pb.getOthersql2()!=null) c.andYhc005EqualTo(pb.getOthersql2());
        if(pb.getOthersql3()!=null) c.andYhc006EqualTo(pb.getOthersql3());
        if(pb.getOthersql4()!=null) c.andYhc004GreaterThanOrEqualTo(sf.parse(pb.getOthersql4()+" 00:00:00"));
        if(pb.getOthersql5()!=null) c.andYhc004LessThanOrEqualTo(sf.parse(pb.getOthersql5()+" 23:59:59"));
        if(pb.getOthersql7()!=null)c.andSql("(DATE_FORMAT(yhc008,'%Y-%m-%d')='"+pb.getOthersql7()+"')");
        if(pb.getOthersql8()!=null)c.andSql("(DATE_FORMAT(yhc008,'%Y-%m')='"+pb.getOthersql8()+"')");
        e1.setOrderByClause("yhc004 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public PageBean selectPageBean1(PageBean pb) {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andYhc002EqualTo(Integer.valueOf(pb.getOthersql()));
        if(pb.getOthersql2()!=null) {
//            if(pb.getOthersql2().equals("Y")){
//                c.andYhc001In(Arrays.asList("Y","M"));
//            }else{
                c.andYhc005EqualTo(pb.getOthersql2());
//            }
        }
        e1.setOrderByClause("yhc004 desc");
        return queryByPage1(pb, e1);
    }

    @Override
    public void updateByqsid(Date time) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andYhc008GreaterThanOrEqualTo(sf.parse(sf1.format(time)+" 00:00:00"));
        c.andYhc008LessThanOrEqualTo(sf.parse(sf1.format(time)+" 23:59:59"));
        c.andYhc005EqualTo("Y");
        cdyhc yhc=new cdyhc();
        yhc.setYhc005("M");
        yhcMapper.updateByExampleSelective(yhc,e1);
    }

    @Override
    public cdyhc selectByStr(String nonce_str) {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andYhc011EqualTo(nonce_str);
        List<cdyhc> list = yhcMapper.selectByExample(e1);
        return list.size()>0?list.get(0):null;
    }

    public PageBean queryByPage1(PageBean pageBean, cdyhcExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yhcMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdyhc> list = yhcMapper.selectByExampleAndPage1(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }

    @Override
    public boolean update(cdyhc yhc) {
        return yhcMapper.updateByPrimaryKeySelective(yhc) > 0 ? true : false;
    }

    @Override
    public cdyhc insert(cdyhc yhc) {
        yhcMapper.insertSelective(yhc);
        return yhc;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdyhc yhc = new cdyhc();
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<String> list = (List<String>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andYhc001In(list);
        }
        yhcMapper.updateByExampleSelective(yhc, e1);
    }

    @Override
    public Float selectBygsid(Date time, Integer gsid, String fkzt, String zt) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andYhc008GreaterThanOrEqualTo(sf.parse(sf1.format(time)+" 00:00:00"));
        c.andYhc008LessThanOrEqualTo(sf.parse(sf1.format(time)+" 23:59:59"));
        c.andYhc003EqualTo(gsid);
        c.andYhc006EqualTo(fkzt);
        if(zt!=null){
            c.andYhc005EqualTo(zt);
        }else{
            c.andSql("(yhc005='Y' or yhc005='M')");
        }
        return yhcMapper.countByExampleje(e1);
    }

    @Override
    public Float selectBygsidY(String time, Integer gsid, String fkzt, String zt) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andSql("(DATE_FORMAT(yhc008,'%Y-%m')='"+time+"')");
        c.andYhc003EqualTo(gsid);
        c.andYhc006EqualTo(fkzt);
        if(zt!=null){
            c.andYhc005EqualTo(zt);
        }else{
            c.andSql("(yhc005='Y' or yhc005='M')");
        }
        return yhcMapper.countByExampleje(e1);
    }

    @Override
    public   List<cdyhc> selectBygsiddz(String time,Integer gsid) {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andSql("(DATE_FORMAT(yhc008,'%Y-%m')='"+time+"')");
        c.andYhc003EqualTo(gsid);
        return yhcMapper.selectByExample1(e1);
    }
    @Override
    public   List<cdyhc> selectBygsiddz1(String time,Integer gsid) {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andSql("(DATE_FORMAT(yhc008,'%Y-%m-%d')='"+time+"')");
        c.andYhc003EqualTo(gsid);
        return yhcMapper.selectByExample1(e1);
    }

    @Override
    public List<cdyhc> selectByyhid(Integer yhid, String time, String zt) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andYhc002EqualTo(yhid);
        if(time!=null){
            c.andYhc008GreaterThanOrEqualTo(sf.parse(time+" 00:00:00"));
            c.andYhc008LessThanOrEqualTo(sf.parse(time+" 23:59:59"));
        }
        c.andYhc005EqualTo(zt);
        return yhcMapper.selectByExample(e1);
    }

    @Override
    public List<cdyhc> selectByyhid1(Integer yhid, String time) throws ParseException {
        cdyhcExample e1 = new cdyhcExample();
        Criteria c = e1.createCriteria();
        c.andYhc002EqualTo(yhid);
        if(time!=null){
            c.andYhc008GreaterThanOrEqualTo(sf.parse(time+" 00:00:00"));
            c.andYhc008LessThanOrEqualTo(sf.parse(time+" 23:59:59"));
        }
        return yhcMapper.selectByExample(e1);
    }

    public PageBean queryByPage(PageBean pageBean, cdyhcExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) yhcMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdyhc> list = yhcMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }


    @Override
    public boolean saveBatch(Collection<cdyhc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdyhc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdyhc> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdyhc entity) {
        return false;
    }

    @Override
    public cdyhc getOne(Wrapper<cdyhc> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdyhc> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdyhc> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdyhc> getBaseMapper() {
        return null;
    }
}
