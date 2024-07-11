package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cduse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CduseService extends IService<cduse> {

    cduse getLogin(String name, String pwd);

    cduse getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cduse use);

    cduse insert(cduse use);

    void deleteById(String id, PageBean pb);


    cduse selectByName(String name);

    void delete(int id);
}
