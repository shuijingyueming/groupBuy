package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdysa;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdysaService extends IService<cdysa> {
    cdysa getByid(Integer id);


    boolean update(cdysa ysa);

    cdysa insert(cdysa ysa);

    void deleteById(String id, PageBean pb);


    cdysa selectByName(String name);

    List<cdysa> serachAll(String name);

    void delete(Integer id);

    List<cdysa> selectBysjid(Integer id);
}
