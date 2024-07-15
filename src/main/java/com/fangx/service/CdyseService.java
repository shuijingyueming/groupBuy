package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyse;

import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyseService extends IService<cdyse> {
    cdyse getByid(String id);

    PageBean selectPageBean(PageBean pb) throws ParseException;

    boolean update(cdyse yse);

    cdyse insert(cdyse yse);

    void deleteById(String id, PageBean pb);


    cdyse selectByName(Integer name);

    cdyse selectBycurentday(Date time, Integer gsid) throws ParseException;

    cdyse selectByDS(String date, Integer gsid);
}
