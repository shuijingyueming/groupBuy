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
import java.util.Date;
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

    protected final static SimpleDateFormat TIMEMIAO1 = new SimpleDateFormat("yyyy-MM-dd");

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
    public void delete(Integer id) {
        ysbMapper.deleteByPrimaryKey(id);
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
    public boolean update(cdysb ysb) {
        return ysbMapper.updateByPrimaryKeySelective(ysb) > 0 ? true : false;
    }

    @Override
    public cdysb insert(cdysb ysb) { ysbMapper.insertSelective(ysb); return ysb;}

    @Override
    public void deleteBygstime(Integer id, String time, String time1, String lx, String zt) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andYsb003GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(time1 !=null)c.andYsb004LessThanOrEqualTo(TIMEMIAO.parse(time1+" 23:59:59"));
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
         ysbMapper.deleteByExample(e1);
    }

    @Override
    public void deleteBytime(Date time, Integer id) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andYsb004GreaterThan(TIMEMIAO.parse(TIMEMIAO1.format(time)+" 00:00:00"));
        ysbMapper.deleteByExample(e1);
    }

    @Override
    public List<cdysb> selectBygstime1(Integer id, String time, String time1, String lx, String zt) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+ time +"')");
        if(time1 !=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+ time1 +"')");
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        return ysbMapper.selectByExample1(e1);
    }
    @Override
    public cdysb selectBygstime2(Integer id, String time, String time1, String lx, String zt) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andYsb003LessThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(time1 !=null)c.andYsb004GreaterThan(TIMEMIAO.parse(time1+" 23:59:59"));
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb004,ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }
    @Override
    public cdysb selectBygstime4(Integer id, String time, String time1, String lx, String zt) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andYsb003LessThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(time1 !=null)c.andYsb004LessThan(TIMEMIAO.parse(time1+" 23:59:59"));
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb004 desc,ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public List<Integer> selectBygstime3( String time, String time1, String lx, String zt) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time !=null){
            c.andYsb003LessThan(TIMEMIAO.parse(time+" 00:00:00"));
        }
        if(time1 !=null){
            c.andYsb004GreaterThan(TIMEMIAO.parse(time1+" 23:59:59"));
        }
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        return ysbMapper.selectByExampleid(e1);
    }

    @Override
    public cdysb selectBygstime(Integer id, String time, String time1, String lx, String zt) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+ time +"')");
        if(time1 !=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+ time1 +"')");
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public Integer countBygstime(Integer id, String time, String time1, String lx, String zt) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+ time +"')");
        if(time1 !=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+ time1 +"')");
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        return Math.toIntExact(ysbMapper.countByExample(e1));
    }

    @Override
    public Integer countBygstime1(Integer id, String time, String time1, String lx, String zt) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(id!=null)c.andYsb002EqualTo(id);
        if(time !=null){
            c.andYsb003LessThan(TIMEMIAO.parse(time+" 00:00:00"));
        }
        if(time1 !=null){
            c.andYsb004GreaterThan(TIMEMIAO.parse(time1+" 23:59:59"));
        }
        if(zt!=null)c.andYsb005EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        return Math.toIntExact(ysbMapper.countByExample(e1));
    }

    @Override
    public void updateByqsid(Integer yqsid, Integer xqsid) {
        cdysb ysb=new cdysb();
        ysb.setYsb006(xqsid);
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb006EqualTo(yqsid);
        ysbMapper.updateByExampleSelective(ysb,e1);
    }



    @Override
    public cdysb selectByqb(String time, String lx) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        c.andYsb007EqualTo("A");
        if(lx!=null) c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }





    @Override
    public cdysb selectBycpid1(String time, String time2, String lx) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        if(time2!=null)c.andSql("(DATE_FORMAT(ysb004,'%Y-%m-%d')='"+time2+"')");
        c.andYsb007EqualTo("A");
        if(lx!=null)c.andYsb008EqualTo(lx);
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }
    @Override
    public List<cdysb> selectBycpid2(String time, String lx) {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(time!=null)c.andSql("(DATE_FORMAT(ysb003,'%Y-%m-%d')='"+time+"')");
        c.andYsb007EqualTo("B");
        if(lx!=null) c.andYsb008EqualTo(lx);
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
    public cdysb selectBygs1(String time, List<Integer> list1, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(lx!=null)c.andYsb008EqualTo(lx);
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
    public cdysb selectBygs2(String time, List<Integer> list1, Integer gsid, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb007EqualTo("B");
        if(lx!=null)c.andYsb008EqualTo(lx);
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
    public cdysb selectBygs3(String time, Integer gsid, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003EqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004IsNull();
//        c.andYsb007EqualTo("B");
        if(lx!=null)c.andYsb008EqualTo(lx);
        c.andSql("(Ysb007='A'  OR (Ysb007='B' and (select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0))");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBygs4(String time, Integer gsid, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003EqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004IsNull();
        c.andYsb007EqualTo("B");
        if(lx!=null)c.andYsb008EqualTo(lx);
        c.andSql("((select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBygs5(String time, String zt, Integer gsid, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb007EqualTo(zt);
        if(lx!=null)c.andYsb008EqualTo(lx);
        if(gsid!=null)c.andSql("((select count(*) from cdyhb left join cdusb on usb001=yhb002 where DayOfWeek(Ysb003)=usb003 and yhb003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    @Override
    public cdysb selectBygs6(String time, List<Integer> list1, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004IsNull();
        if(lx!=null)c.andYsb008EqualTo(lx);
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
    public cdysb selectBycpid(String name, String name1, String zt, String zt1) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        if(name!=null)c.andYsb003EqualTo(TIMEMIAO.parse(name+" 00:00:00"));
        if(name1!=null)c.andYsb004EqualTo(TIMEMIAO.parse(name1+" 00:00:00"));
        c.andYsb007EqualTo(zt);
        c.andYsb008EqualTo(zt1);
        List<cdysb> list = ysbMapper.selectByExample(e1);
        return list!=null&&list.size()>0?list.get(0):null;
    }




    @Override
    public cdysb selectBygs1y(String time, List<Integer> list1, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        if(lx!=null)c.andYsb008EqualTo(lx);
        if(list1.size()>0){
            String sql="";
            sql+=" (";
            for(Integer i:list1){
                sql+=" DATE_FORMAT(ysb003,'%d') = "+i+" ";
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
    public cdysb selectBygs2y(String time, List<Integer> list1, Integer gsid, String lx) throws ParseException {
        cdysbExample e1 = new cdysbExample();
        Criteria c = e1.createCriteria();
        c.andYsb003LessThanOrEqualTo(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb004GreaterThan(TIMEMIAO.parse(time+" 00:00:00"));
        c.andYsb007EqualTo("B");
        if(lx!=null)c.andYsb008EqualTo(lx);
        c.andSql("((select count(*) from cdysd where ysd002=ysb001 and ysd003='"+gsid+"')>0)");
        e1.setOrderByClause("ysb003");
        if(list1.size()>0){
            String sql="";
            sql+=" (";
            for(Integer i:list1){
                sql+=" DATE_FORMAT(ysb003,'%d') = "+i+" ";
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
