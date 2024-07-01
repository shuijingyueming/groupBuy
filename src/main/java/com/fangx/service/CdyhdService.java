package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyhdService extends IService<cdyhd> {
    cdyhd getByid(String id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdyhd yhd);

    cdyhd insert(cdyhd yhd);

    void deleteById(String id, PageBean pb);


    List<cdyhd> selectByyhid(Integer id);

}
