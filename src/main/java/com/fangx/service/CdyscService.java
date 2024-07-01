package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdysc;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdyscService extends IService<cdysc> {
    cdysc getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdysc ysc);

    cdysc insert(cdysc ysc);

    List<cdysc> serachAll();

    List<cdysc> selectBycp(Integer cpid, String date);

    cdysc selectBycpid(Integer cpid, String time);

    void delete(Integer id);
}
