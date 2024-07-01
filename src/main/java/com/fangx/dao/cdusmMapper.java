package com.fangx.dao;

import com.fangx.model.cdusm;
import com.fangx.model.cdusmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cdusmMapper {
    long countByExample(cdusmExample example);

    int deleteByExample(cdusmExample example);

    int deleteByPrimaryKey(Integer usm001);

    int insert(cdusm record);

    int insertSelective(cdusm record);

    List<cdusm> selectByExample(cdusmExample example);

    cdusm selectByPrimaryKey(Integer usm001);

    int updateByExampleSelective(@Param("record") cdusm record, @Param("example") cdusmExample example);

    int updateByExample(@Param("record") cdusm record, @Param("example") cdusmExample example);

    int updateByPrimaryKeySelective(cdusm record);

    int updateByPrimaryKey(cdusm record);

    List<cdusm> selectByExampleAndPage(cdusmExample example, RowBounds rowBounds);
}