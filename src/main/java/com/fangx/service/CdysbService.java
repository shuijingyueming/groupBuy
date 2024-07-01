package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdyhb;
import com.fangx.model.cdysb;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdysbService extends IService<cdysb> {
    cdysb getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdysb ysb);

    cdysb insert(cdysb ysb);

    List<cdysb> serachAll();

    List<cdysb> selectBygsid(Integer gsid);

    cdysb selectBygsid(Integer gsid, String time);

    void delete(Integer id);

    cdysb selectBycpid(String time, String time2);
}
