package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdlog;

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
public interface CdlogService extends IService<cdlog> {
    void insert(cdlog log);

    void deleteByTime(Date date);

    PageBean selectPageBean(PageBean pb) throws ParseException;

    void deleteById(String id);
}
