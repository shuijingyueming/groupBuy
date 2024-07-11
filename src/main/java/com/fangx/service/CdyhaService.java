package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyha;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyhaService extends IService<cdyha> {
    cdyha getByid(Integer id);


    boolean update(cdyha yha);

    cdyha insert(cdyha yha);

    void deleteById(String id, PageBean pb);

    List<cdyha> serachAll(Integer cpid);

    void deletebyid(Integer cpid);
    void delete(Integer id);

    cdyha getByqscp(Integer qsid, Integer id);

    void deleteByqsid(Integer qsid);

    void updatebyqsid(Integer uid, Integer id);

    cdyha selectByqscp(Integer qsid, Integer cpid);
}
