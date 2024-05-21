package com.fangx.dao;

import com.fangx.model.cdusf;
import com.fangx.model.cdusfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusfMapper {
    long countByExample(cdusfExample example);

    int deleteByExample(cdusfExample example);

    int deleteByPrimaryKey(Integer usf001);

    int insert(cdusf record);

    int insertSelective(cdusf record);

    List<cdusf> selectByExample(cdusfExample example);

    cdusf selectByPrimaryKey(Integer usf001);

    int updateByExampleSelective(@Param("record") cdusf record, @Param("example") cdusfExample example);

    int updateByExample(@Param("record") cdusf record, @Param("example") cdusfExample example);

    int updateByPrimaryKeySelective(cdusf record);

    int updateByPrimaryKey(cdusf record);
}