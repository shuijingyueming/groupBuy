package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.cdush;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdushService extends IService<cdush> {
    cdush getByid(String id);


    boolean update(cdush ush);

    cdush insert(cdush ush);

    void deleteById(String id);

    List<cdush> serachAll(String cpid);

    void deletebyid(String cpid);
    void delete(String id);

    List<cdush> selectByyhid(Integer yhid);

    List<cdush> selectByyhidjs(Integer yhid, String id);

    cdush selectByyhcp(Integer yhid, Integer cpid);

    List<cdush> selectByyhidtk(String ddid);
}
