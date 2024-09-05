package com.fangx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fangx.model.PageBean;
import com.fangx.model.cdusg;

import java.text.ParseException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dps
 * @since 2023-03-15
 */
public interface CdusgService extends IService<cdusg> {
    cdusg getByid(String id);

    boolean update(cdusg usg);

    cdusg insert(cdusg usg);

    void deleteById(String id, PageBean pb);

    cdusg selectByName(Integer name);

    void delete(String jgid);

    cdusg getBycpgs(Integer cpid, Integer gsid);
}
