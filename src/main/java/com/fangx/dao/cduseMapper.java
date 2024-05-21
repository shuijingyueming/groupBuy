package com.fangx.dao;

import com.fangx.model.cduse;
import com.fangx.model.cduseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cduseMapper {
    long countByExample(cduseExample example);

    int deleteByExample(cduseExample example);

    int deleteByPrimaryKey(Integer use001);

    int insert(cduse record);

    int insertSelective(cduse record);

    List<cduse> selectByExample(cduseExample example);

    cduse selectByPrimaryKey(Integer use001);

    int updateByExampleSelective(@Param("record") cduse record, @Param("example") cduseExample example);

    int updateByExample(@Param("record") cduse record, @Param("example") cduseExample example);

    int updateByPrimaryKeySelective(cduse record);

    int updateByPrimaryKey(cduse record);
}