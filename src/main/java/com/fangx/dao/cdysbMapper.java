package com.fangx.dao;

import com.fangx.model.cdysb;
import com.fangx.model.cdysbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cdysbMapper {
    long countByExample(cdysbExample example);

    int deleteByExample(cdysbExample example);

    int deleteByPrimaryKey(Integer ysb001);

    int insert(cdysb record);

    int insertSelective(cdysb record);

    List<cdysb> selectByExample(cdysbExample example);

    cdysb selectByPrimaryKey(Integer ysb001);

    int updateByExampleSelective(@Param("record") cdysb record, @Param("example") cdysbExample example);

    int updateByExample(@Param("record") cdysb record, @Param("example") cdysbExample example);

    int updateByPrimaryKeySelective(cdysb record);

    int updateByPrimaryKey(cdysb record);

    List<cdysb> selectByExampleAndPage(cdysbExample example, RowBounds rowBounds);
}