package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusm;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusmService extends IService<cdusm> {
    cdusm getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdusm usm);

    cdusm insert(cdusm usm);

    void deleteById(String id, PageBean pb);


    cdusm selectByName(String name);

    List<cdusm> serachAll();

    void delete(Integer id);
}
