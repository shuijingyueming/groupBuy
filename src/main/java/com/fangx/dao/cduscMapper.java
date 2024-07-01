package com.fangx.dao;

import com.fangx.model.cdusc;
import com.fangx.model.cduscExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cduscMapper {
    long countByExample(cduscExample example);

    int deleteByExample(cduscExample example);

    int deleteByPrimaryKey(Integer usc001);

    int insert(cdusc record);

    int insertSelective(cdusc record);

    List<cdusc> selectByExample(cduscExample example);

    cdusc selectByPrimaryKey(Integer usc001);

    cdusc selectByPrimaryKey1(Integer usc001);

    int updateByExampleSelective(@Param("record") cdusc record, @Param("example") cduscExample example);

    int updateByExample(@Param("record") cdusc record, @Param("example") cduscExample example);

    int updateByPrimaryKeySelective(cdusc record);

    int updateByPrimaryKey(cdusc record);

    List<cdusc> selectByExampleAndPage(cduscExample example, RowBounds rowBounds);
}