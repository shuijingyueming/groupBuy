package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhb;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyhbService extends IService<cdyhb> {
    cdyhb getByid(String id);


    boolean update(cdyhb yhb);

    cdyhb insert(cdyhb yhb);

    void deleteById(String id, PageBean pb);

    List<cdyhb> serachAll(Integer cpid);

    void deletebyid(Integer cpid);
    void delete(String id);
}
