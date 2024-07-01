package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusn;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusnService extends IService<cdusn> {
    cdusn getByid(Integer id);


    boolean update(cdusn usn);

    cdusn insert(cdusn usn);

    void deleteById(List<String> id);

    List<cdusn> serachAll(Integer cpid);

    void deletebyid(Integer cpid);
    void delete(Integer id);
}
