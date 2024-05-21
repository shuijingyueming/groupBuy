package com.fangx.dao;

import com.fangx.model.cdyhk;
import com.fangx.model.cdyhkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdyhkMapper {
    long countByExample(cdyhkExample example);

    int deleteByExample(cdyhkExample example);

    int deleteByPrimaryKey(String yhk001);

    int insert(cdyhk record);

    int insertSelective(cdyhk record);

    List<cdyhk> selectByExample(cdyhkExample example);

    cdyhk selectByPrimaryKey(String yhk001);

    int updateByExampleSelective(@Param("record") cdyhk record, @Param("example") cdyhkExample example);

    int updateByExample(@Param("record") cdyhk record, @Param("example") cdyhkExample example);

    int updateByPrimaryKeySelective(cdyhk record);

    int updateByPrimaryKey(cdyhk record);
}