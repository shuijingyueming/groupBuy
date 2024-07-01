package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusa;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusaService extends IService<cdusa> {
    List<cdusa> serachAll();

    PageBean selectPageBean(PageBean pb);

    cdusa getByid(Integer id);

    void update(cdusa usa);

    cdusa insert(cdusa usa);

    void deleteById(int id);

    void deleteById(String id);
}
