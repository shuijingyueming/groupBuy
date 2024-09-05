package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhc;

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
public interface CdyhcService extends IService<cdyhc> {


    cdyhc getByid(String id);

    PageBean selectPageBean(PageBean pb) throws ParseException;

    boolean update(cdyhc yhc);

    cdyhc insert(cdyhc yhc);

    void deleteById(String id, PageBean pb);

    Float selectBygsid(Date time, Integer gsid, String fkzt, String zt) throws ParseException;

    Float selectBygsidY(String start,Integer gsid, String fkzt, String zt) throws ParseException;

    List<cdyhc> selectByyhid(Integer yhid, String date, String zt) throws ParseException;

    PageBean selectPageBean1(PageBean pagebean);

    void updateByqsid(Date time) throws ParseException;

    cdyhc selectByStr(String nonce_str);

    List<cdyhc> selectByyhid1(Integer usc001, String date) throws ParseException;

    List<cdyhc> selectBygsiddz(String time,Integer gsid);
    List<cdyhc> selectBygsiddz1(String time,Integer gsid);
}
