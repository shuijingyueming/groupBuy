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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    protected final static SimpleDateFormat TIMEMIAO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private cdysbMapper ysbMapper;

    @Override
    public cdysb getByid(Integer id) {
        return ysbMapper.selectByPrimaryKey(id);
    }

    @Override
    public cdysb getByid1(Integer id) {
        return ysbMapper.selectByPrimaryKey1(id);
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
    public cdysb selectBycpid(String time, String time2, String zt) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        if(time2!=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+time2+"')");
        if(zt!=null)c.andYsb007EqualTo(zt);
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBycpid1(String time, String time2) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        if(time2!=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+time2+"')");
        c.andYsb007EqualTo("A");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }
    @Override
    public List<cdysb> selectBycpid2(String time) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        c.andYsb007EqualTo("B");
        e1.setOrderByClause("ysb003");
        return  ysbMapper.selectByExample(e1);
    }

    @Override
    public cdysb selectBygs(String time, List<Integer> list1) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(list1.size()>0){
            String sql="";
            sql+=" (";
            for(Integer i:list1){
                sql+=" DayOfWeek(ysb003) = "+i+" ";
                sql+="or";
            }
            sql=sql.substring(0,sql.length()-2);
            sql+=" )";
            c.andSql(sql);
            e1.setOrderByClause("ysb003");
            List<cdysb> list = ysbMapper.selectByExample(e1);
            return list!=null&&list.size()>0?list.get(0):null;
        }
        return null;
    }

    @Override
    public cdysb selectBygs1(String time, List<Integer> list1) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(list1.size()>0){
            String sql="";
            sql+=" (";
            for(Integer i:list1){
                sql+=" DayOfWeek(ysb003) = "+i+" ";
                sql+="or";
            }
            sql=sql.substring(0,sql.length()-2);
            sql+=" )";
            c.andSql(sql);
            e1.setOrderByClause("ysb003");
            List<cdysb> list = ysbMapper.selectByExample(e1);
            return list!=null&&list.size()>0?list.get(0):null;
        }
        return null;
    }

    @Override
    public cdysb selectBygs2(String time, List<Integer> list1, Integer gsid) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb007EqualTo("B");
        c.andSql("((select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        if(list1.size()>0){
            String sql="";
            sql+=" (";
            for(Integer i:list1){
                sql+=" DayOfWeek(ysb003) = "+i+" ";
                sql+="or";
            }
            sql=sql.substring(0,sql.length()-2);
            sql+=" )";
            c.andSql(sql);
            e1.setOrderByClause("ysb003");
            List<cdysb> list = ysbMapper.selectByExample(e1);
            return list!=null&&list.size()>0?list.get(0):null;
        }
        return null;
    }

    @Override
    public cdysb selectBygs3(String time, Integer gsid) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004IsNull();
        c.andYsb007EqualTo("B");
        c.andSql("((select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBygs4(String time, Integer gsid) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003EqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004IsNull();
        c.andYsb007EqualTo("B");
        c.andSql("((select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBygs5(String time, String zt, Integer gsid) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb007EqualTo(zt);
        if(gsid!=null)c.andSql("((select count(*) from cdyhb left join cdusb on usb001=yhb002 where DayOfWeek(Ysb003)=usb003 and yhb003='"+gsid+"')>0)");
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
