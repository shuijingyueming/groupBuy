package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusc;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CduscService extends IService<cdusc> {
    cdusc getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdusc usc);

    cdusc insert(cdusc usc);

    void deleteById(String id, PageBean pb);


    cdusc selectByName(String name);

    List<cdusc> serachAll(Integer id);

    cdusc selectByOpenid(String openid);

    cdusc selectByPhone(String phone);

    cdusc selectBygsid(String name, String phone, Integer gsid);
}
