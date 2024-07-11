package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusdService extends IService<cdusd> {
    cdusd getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdusd usd);

    cdusd insert(cdusd usd);

    void deleteById(String id, PageBean pb);


    cdusd selectByName(String name);

    List<cdusd> serachAll();

    List<cdusd> serachBytime(Integer weekDay);
}
