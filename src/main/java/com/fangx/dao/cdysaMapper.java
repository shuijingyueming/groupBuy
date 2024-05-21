package com.fangx.dao;

import com.fangx.model.cdysa;
import com.fangx.model.cdysaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdysaMapper {
    long countByExample(cdysaExample example);

    int deleteByExample(cdysaExample example);

    int deleteByPrimaryKey(Integer ysa001);

    int insert(cdysa record);

    int insertSelective(cdysa record);

    List<cdysa> selectByExample(cdysaExample example);

    cdysa selectByPrimaryKey(Integer ysa001);

    int updateByExampleSelective(@Param("record") cdysa record, @Param("example") cdysaExample example);

    int updateByExample(@Param("record") cdysa record, @Param("example") cdysaExample example);

    int updateByPrimaryKeySelective(cdysa record);

    int updateByPrimaryKey(cdysa record);
}