package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhe;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyheService extends IService<cdyhe> {
    cdyhe getByid(Integer id);


    boolean update(cdyhe yhe);

    cdyhe insert(cdyhe yhe);

    void deleteById(String id, PageBean pb);


    cdyhe selectByName(String name);

    List<cdyhe> serachAll(String name);

    void delete(Integer id);
}
