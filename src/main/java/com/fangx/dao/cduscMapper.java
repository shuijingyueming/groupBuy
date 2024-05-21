package com.fangx.dao;

import com.fangx.model.cdusc;
import com.fangx.model.cduscExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cduscMapper {
    long countByExample(cduscExample example);

    int deleteByExample(cduscExample example);

    int deleteByPrimaryKey(Integer usc001);

    int insert(cdusc record);

    int insertSelective(cdusc record);

    List<cdusc> selectByExample(cduscExample example);

    cdusc selectByPrimaryKey(Integer usc001);

    int updateByExampleSelective(@Param("record") cdusc record, @Param("example") cduscExample example);

    int updateByExample(@Param("record") cdusc record, @Param("example") cduscExample example);

    int updateByPrimaryKeySelective(cdusc record);

    int updateByPrimaryKey(cdusc record);
}