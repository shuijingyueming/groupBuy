package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusb;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusbService extends IService<cdusb> {
    cdusb getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdusb usb);

    cdusb insert(cdusb usb);

    cdusb selectByName(String name);

    List<cdusb> serachAll();

    cdusb selectByweek(Integer gsid, Integer d);
    cdusb selectByweek1(Integer gsid, Integer d);
    cdusb selectByweek2(Integer d);

    cdusb selectByzq(Integer i);
}
