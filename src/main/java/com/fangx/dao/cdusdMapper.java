package com.fangx.dao;

import com.fangx.model.cdusd;
import com.fangx.model.cdusdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cdusdMapper {
    long countByExample(cdusdExample example);

    int deleteByExample(cdusdExample example);

    int deleteByPrimaryKey(Integer usd001);

    int insert(cdusd record);

    int insertSelective(cdusd record);

    List<cdusd> selectByExample(cdusdExample example);

    cdusd selectByPrimaryKey(Integer usd001);

    cdusd selectByPrimaryKey1(Integer usd001);

    int updateByExampleSelective(@Param("record") cdusd record, @Param("example") cdusdExample example);

    int updateByExample(@Param("record") cdusd record, @Param("example") cdusdExample example);

    int updateByPrimaryKeySelective(cdusd record);

    int updateByPrimaryKey(cdusd record);

    List<cdusd> selectByExampleAndPage(cdusdExample example, RowBounds rowBounds);
}