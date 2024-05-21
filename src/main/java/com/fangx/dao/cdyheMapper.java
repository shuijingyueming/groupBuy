package com.fangx.dao;

import com.fangx.model.cdyhe;
import com.fangx.model.cdyheExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdyheMapper {
    long countByExample(cdyheExample example);

    int deleteByExample(cdyheExample example);

    int deleteByPrimaryKey(Integer yhe001);

    int insert(cdyhe record);

    int insertSelective(cdyhe record);

    List<cdyhe> selectByExample(cdyheExample example);

    cdyhe selectByPrimaryKey(Integer yhe001);

    int updateByExampleSelective(@Param("record") cdyhe record, @Param("example") cdyheExample example);

    int updateByExample(@Param("record") cdyhe record, @Param("example") cdyheExample example);

    int updateByPrimaryKeySelective(cdyhe record);

    int updateByPrimaryKey(cdyhe record);
}