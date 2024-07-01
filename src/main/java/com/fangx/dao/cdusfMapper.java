package com.fangx.dao;

import com.fangx.model.cdusf;
import com.fangx.model.cdusfExample;
import java.util.List;

import com.fangx.model.cdyhaExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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

    List<cdusf> selectByExampleAndPage(cdusfExample example, RowBounds rowBounds);

    cdusf selectByPrimaryKey1(Integer id);

    long countByExampleqs(@Param("cdusfExample")cdusfExample e1, @Param("cdyhaExample")cdyhaExample e2);

    List<cdusf> selectByExampleAndPageqs(@Param("cdusfExample")cdusfExample e1, @Param("cdyhaExample")cdyhaExample e2, RowBounds rowBounds);

    List<cdusf> selectByExampleAndPage2(cdusfExample e1, RowBounds rowBounds);
}