package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhk;

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
public interface CdyhkService extends IService<cdyhk> {
    cdyhk getByid(String id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdyhk yhk);

    cdyhk insert(cdyhk yhk);

    void deleteById(String id, PageBean pb);


    cdyhk selectByName(Integer name);

    cdyhk selectBycurentday(Date time, Integer gsid) throws ParseException;
}
