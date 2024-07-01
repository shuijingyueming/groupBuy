package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusf;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusfService extends IService<cdusf> {
    cdusf getByid(Integer id);

    PageBean selectPageBean(PageBean pb);

    boolean update(cdusf usf);

    cdusf insert(cdusf usf);

    void deleteById(String id, PageBean pb);


    cdusf selectByName(String name);

    List<cdusf> serachAll();

    PageBean selectPageBean1(PageBean pb);

    List<cdusf> selectByDD(Integer usc001, String qsid);

    PageBean selectPageBean2(PageBean pb);

    List<cdusf> selectByCG(String date);
}
