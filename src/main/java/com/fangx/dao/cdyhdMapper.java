package com.fangx.dao;

import com.fangx.model.cdyhd;
import com.fangx.model.cdyhdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdyhdMapper {
    long countByExample(cdyhdExample example);

    int deleteByExample(cdyhdExample example);

    int deleteByPrimaryKey(String yhd001);

    int insert(cdyhd record);

    int insertSelective(cdyhd record);

    List<cdyhd> selectByExample(cdyhdExample example);

    cdyhd selectByPrimaryKey(String yhd001);

    int updateByExampleSelective(@Param("record") cdyhd record, @Param("example") cdyhdExample example);

    int updateByExample(@Param("record") cdyhd record, @Param("example") cdyhdExample example);

    int updateByPrimaryKeySelective(cdyhd record);

    int updateByPrimaryKey(cdyhd record);
}