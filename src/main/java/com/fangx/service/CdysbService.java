package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdysb;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdysbService extends IService<cdysb> {
    cdysb selectByqb(String time, String lx);

    cdysb getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdysb ysb);

    cdysb insert(cdysb ysb);

    cdysb selectBygs(String time, List<Integer> list) throws ParseException;
    cdysb selectBygs1(String time, List<Integer> list, String lx) throws ParseException;

    cdysb getByid1(Integer id);

    cdysb selectBycpid1(String time, String time2, String lx);

    cdysb selectBygs2(String time, List<Integer> list, Integer gsid, String lx) throws ParseException;
    cdysb selectBygs3(String time, Integer gsid, String lx) throws ParseException;

    cdysb selectBygs4(String time, Integer gsid, String lx) throws ParseException;

    cdysb selectBygs5(String time, String zt, Integer gsid, String lx)throws ParseException;

    List<cdysb> selectBycpid2(String time, String lx);

    cdysb selectBygs6(String time, List<Integer> list, String lx) throws ParseException;

    cdysb selectBycpid(String name, String name1, String zt, String zt1) throws ParseException;

    cdysb selectBygs1y(String time, List<Integer> list, String lx) throws ParseException;

    cdysb selectBygs2y(String time, List<Integer> list1, Integer gsid, String lx)throws ParseException;

    List<cdysb> selectBygstime1(Integer id, String time, String time1, String lx, String zt);
    cdysb selectBygstime(Integer id, String time, String time1, String lx, String zt);
    cdysb selectBygstime2(Integer id, String time, String time1, String lx, String zt) throws ParseException;

    cdysb selectBygstime4(Integer id, String time, String time1, String lx, String zt) throws ParseException;
    List<Integer> selectBygstime3( String time, String time1, String lx, String zt) throws ParseException;

    Integer countBygstime(Integer id, String time, String time1, String lx, String zt);

    Integer countBygstime1(Integer id, String time, String time1, String lx, String zt) throws ParseException;

    void updateByqsid(Integer yqsid, Integer xqsid);

    void delete(Integer id);

    void deleteBygstime(Integer id, String time, String time1, String lx, String zt) throws ParseException;

    void deleteBytime(Date time, Integer id) throws ParseException;
}
