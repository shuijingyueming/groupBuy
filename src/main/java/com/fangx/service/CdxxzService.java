package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.cdxxz;
import com.fangx.model.cdxxzWithBLOBs;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdxxzService extends IService<cdxxz> {
    cdxxzWithBLOBs selGetAll();

    cdxxzWithBLOBs insert();

    void update(cdxxzWithBLOBs xxz);

    cdxxzWithBLOBs selectByid(Integer id);

    cdxxzWithBLOBs insert1();
}
