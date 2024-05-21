package com.fangx.dao;

import com.fangx.model.cdyhc;
import com.fangx.model.cdyhcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdyhcMapper {
    long countByExample(cdyhcExample example);

    int deleteByExample(cdyhcExample example);

    int deleteByPrimaryKey(String yhc001);

    int insert(cdyhc record);

    int insertSelective(cdyhc record);

    List<cdyhc> selectByExample(cdyhcExample example);

    cdyhc selectByPrimaryKey(String yhc001);

    int updateByExampleSelective(@Param("record") cdyhc record, @Param("example") cdyhcExample example);

    int updateByExample(@Param("record") cdyhc record, @Param("example") cdyhcExample example);

    int updateByPrimaryKeySelective(cdyhc record);

    int updateByPrimaryKey(cdyhc record);
}