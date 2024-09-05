package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdysb;

import java.text.ParseException;
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
    cdysb getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdysb ysb);

    cdysb insert(cdysb ysb);

    List<cdysb> serachAll();

    List<cdysb> selectBygsid(Integer gsid);

    cdysb selectBygsid(Integer gsid, String time);

    void delete(Integer id);

    cdysb selectBycpid(String time, String time2, String zt);

    cdysb selectBygs(String time, List<Integer> list) throws ParseException;
    cdysb selectBygs1(String time, List<Integer> list) throws ParseException;

    cdysb getByid1(Integer id);

    cdysb selectBycpid1(String time, String time2);

    cdysb selectBygs2(String time, List<Integer> list, Integer gsid) throws ParseException;
    cdysb selectBygs3(String time, Integer gsid) throws ParseException;

    cdysb selectBygs4(String time, Integer gsid) throws ParseException;

    cdysb selectBygs5(String time,String zt, Integer gsid)throws ParseException;

    List<cdysb> selectBycpid2(String time);

    cdysb selectBygs6(String time, List<Integer> list) throws ParseException;
}
