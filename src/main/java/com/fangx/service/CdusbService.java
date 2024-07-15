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

    List<cdusb> serachAll(Integer gsid);

    List<cdusb> serachAll1();

    cdusb selectByweek(Integer gsid, Integer d);
    cdusb selectByweek1(Integer gsid, Integer d);
    cdusb selectByweek2(Integer d);

    cdusb selectByweek3(Integer gsid, Integer d, Integer id);
    cdusb selectByweek4(Integer gsid, Integer d, Integer id);

    cdusb selectByweek5(Integer gsid, Integer d, Integer id);
    cdusb selectByweek6(Integer gsid, Integer d, Integer id);

    cdusb selectByzq(Integer i);

    List<Integer> serachAllweek(Integer gsid);

    cdusb getBytime(String time);

    void delete(Integer id);

    List<cdusb> serachBygs();
}
