package com.fangx.dao;

import com.fangx.model.cdlog;
import com.fangx.model.cdlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cdlogMapper {
    long countByExample(cdlogExample example);

    int deleteByExample(cdlogExample example);

    int deleteByPrimaryKey(String log001);

    int insert(cdlog record);

    int insertSelective(cdlog record);

    List<cdlog> selectByExample(cdlogExample example);

    cdlog selectByPrimaryKey(String log001);

    int updateByExampleSelective(@Param("record") cdlog record, @Param("example") cdlogExample example);

    int updateByExampleWithBLOBs(@Param("record") cdlog record, @Param("example") cdlogExample example);

    int updateByExample(@Param("record") cdlog record, @Param("example") cdlogExample example);

    int updateByPrimaryKeySelective(cdlog record);

    int updateByPrimaryKeyWithBLOBs(cdlog record);

    int updateByPrimaryKey(cdlog record);

    List selectByExampleAndPage(cdlogExample example, RowBounds rowBounds);
}