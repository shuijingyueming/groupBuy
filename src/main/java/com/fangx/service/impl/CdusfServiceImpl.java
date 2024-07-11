package com.fangx.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fangx.dao.cdusfMapper;
import com.fangx.dao.cdushMapper;
import com.fangx.dao.cdyhaMapper;
import com.fangx.model.PageBean;
import com.fangx.model.cdusf;
import com.fangx.model.cdusfExample;
import com.fangx.model.cdusfExample.Criteria;
import com.fangx.model.cdyhaExample;
import com.fangx.service.CdusfService;
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
public class CdusfServiceImpl implements CdusfService {

    @Autowired
    private cdusfMapper usfMapper;

    @Autowired
    private cdyhaMapper yhaMapper;
    @Autowired
    private cdushMapper ushMapper;

    @Override
    public cdusf getByid(Integer id) {
        return usfMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean selectPageBean(PageBean pb) {
        cdusfExample e1 = new cdusfExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsf002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql1()!=null) c.andUsf013EqualTo(pb.getOthersql1());
        if(pb.getOthersql2()!=null) c.andUsf011EqualTo(Integer.valueOf(pb.getOthersql2()));
        if(pb.getOthersql3()!=null) c.andUsf012EqualTo(Integer.valueOf(pb.getOthersql3()));
        e1.setOrderByClause("usf001 desc");
        return queryByPage(pb, e1);
    }

    @Override
    public boolean update(cdusf usf) {
        return usfMapper.updateByPrimaryKeySelective(usf) > 0 ? true : false;
    }

    @Override
    public cdusf insert(cdusf usf) {
        usfMapper.insertSelective(usf);
        return usf;
    }

    @Override
    public void deleteById(String id, PageBean pb) {
        cdusf usf = new cdusf();
        cdusfExample e1 = new cdusfExample();
        Criteria c = e1.createCriteria();
        if (id != null && !id.isEmpty()) {
            String[] ids = id.split("#");
            @SuppressWarnings("unchecked")
            List<Integer> list = (List<Integer>) (List<?>) Arrays.asList(ids);
            list.removeAll(Collections.singleton(null));
            c.andUsf001In(list);
        }
        usfMapper.updateByExampleSelective(usf, e1);
    }

    @Override
    public cdusf selectByName(String name) {
        cdusfExample e1 = new cdusfExample();
        Criteria c = e1.createCriteria();
        c.andUsf002EqualTo(name);
        List<cdusf> list = usfMapper.selectByExample(e1);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<cdusf> serachAll() {
        return usfMapper.selectByExample(null);
    }

    public PageBean queryByPage(PageBean pageBean, cdusfExample example) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
        int sum = (int) usfMapper.countByExample(example);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
        List<cdusf> list = usfMapper.selectByExampleAndPage(example, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }

    @Override
    public PageBean selectPageBean1(PageBean pb) {
        cdusfExample e1 = new cdusfExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsf002Like("%"+pb.getOthersql()+"%");
//        cdyhaExample e2 = new cdyhaExample();
//        cdyhaExample.Criteria c1 = e2.createCriteria();
//        if(pb.getOthersql1()!=null) c1.andSql("(yha003 is null or yha003='"+pb.getOthersql1()+"')");
        e1.setOrderByClause("usf001 desc");
//        return queryByPage1(pb, e1,e2);
        return queryByPage1(pb, e1,null);
    }

    @Override
    public List<cdusf> selectByDD(Integer yhid, String qsid) {
        List<cdusf> list1 = usfMapper.selectByExample(null);
        List<cdusf> list =new ArrayList<>();
        for(cdusf usf:list1){
            usf.setSl(ushMapper.selectByyhdd(yhid,qsid));
            if(usf.getSl()!=null&&usf.getSl()>0)list.add(usf);
        }
        return list;
    }

    @Override
    public List<cdusf> selectByCG(String qsid) {
        List<cdusf> list1 = usfMapper.selectByExample(null);
        List<cdusf> list =new ArrayList<>();
        for(cdusf usf:list1){
            usf.setSl(ushMapper.selectBycg(qsid));
            if(usf.getSl()!=null&&usf.getSl()>0)list.add(usf);
        }
        return list;
    }


    public PageBean queryByPage1(PageBean pageBean, cdusfExample e1, cdyhaExample e2) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
//        int sum = (int) usfMapper.countByExampleqs(e1,e2);.
        int sum = (int) usfMapper.countByExample(e1);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
//        List<cdusf> list = usfMapper.selectByExampleAndPageqs(e1,e2, new RowBounds((page - 1) * size, size));
        List<cdusf> list = usfMapper.selectByExampleAndPage(e1, new RowBounds((page - 1) * size, size));
        for(cdusf usf:list){
            usf.setYha(yhaMapper.selectByqscp(Integer.valueOf(pageBean.getOthersql1()),usf.getUsf001()));
        }
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }

    @Override
    public PageBean selectPageBean2(PageBean pb) {
        cdusfExample e1 = new cdusfExample();
        Criteria c = e1.createCriteria();
        if(pb.getOthersql()!=null) c.andUsf002Like("%"+pb.getOthersql()+"%");
        if(pb.getOthersql1()!=null) c.andUsf011EqualTo(Integer.valueOf(pb.getOthersql1()));
        if(pb.getOthersql2()!=null) c.andUsf012EqualTo(Integer.valueOf(pb.getOthersql2()));
        c.andUsf013NotEqualTo("C");
        if(pb.getOthersql7()!=null){
            if(pb.getOthersql7().equals("A")){
                e1.setOrderByClause("usf013 desc,usf001 desc");
            }else{
                e1.setOrderByClause("usf008 desc,usf001 desc");
            }
        }else{
            e1.setOrderByClause("usf001 desc");
        }
        return queryByPage2(pb, e1);
    }

    public PageBean queryByPage2(PageBean pageBean, cdusfExample e1) {
        int page = (int) pageBean.getCurrentPage();
        int size = pageBean.getPageSize();
        //record sum
//        int sum = (int) usfMapper.countByExampleqs(e1,e2);.
        int sum = (int) usfMapper.countByExample(e1);
        //page count
        int count = sum % size == 0 ? sum / size : sum / size + 1;
        //check page
        page = page < 1 ? 1 : ((page > count) ? count : page);
        //query
//        List<cdusf> list = usfMapper.selectByExampleAndPageqs(e1,e2, new RowBounds((page - 1) * size, size));
        List<cdusf> list = usfMapper.selectByExampleAndPage2(e1, new RowBounds((page - 1) * size, size));
        //save to PageBean
        pageBean.setCurrentPage(page);
        pageBean.setPageCount(count);
        pageBean.setRecordCount(sum);
        pageBean.setResultList(list);
        pageBean.setPageSize(size);
        return pageBean;
    }
    @Override
    public boolean saveBatch(Collection<cdusf> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<cdusf> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<cdusf> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(cdusf entity) {
        return false;
    }

    @Override
    public cdusf getOne(Wrapper<cdusf> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<cdusf> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<cdusf> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<cdusf> getBaseMapper() {
        return null;
    }
}
