package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.cdysd;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdysdService extends IService<cdysd> {
    cdysd getByid(Integer id);

    boolean update(cdysd ysd);

    cdysd insert(cdysd ysd);

    void deleteById(String id);

    List<cdysd> serachAll(Integer cpid);

    void deletebyid(Integer cpid);
    void delete(Integer id);

    List<cdysd> selectByyhid(Integer yhid);

    List<cdysd> selectByyhidjs(Integer yhid, String id);

    cdysd selectByyhcp(Integer yhid, Integer cpid);
}
