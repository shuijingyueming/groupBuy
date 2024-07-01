package com.fangx.dao;

import com.fangx.model.cdysc;
import com.fangx.model.cdyscExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface cdyscMapper {
    long countByExample(cdyscExample example);

    int deleteByExample(cdyscExample example);

    int deleteByPrimaryKey(Integer ysc001);

    int insert(cdysc record);

    int insertSelective(cdysc record);

    List<cdysc> selectByExample(cdyscExample example);

    cdysc selectByPrimaryKey(Integer ysc001);

    int updateByExampleSelective(@Param("record") cdysc record, @Param("example") cdyscExample example);

    int updateByExample(@Param("record") cdysc record, @Param("example") cdyscExample example);

    int updateByPrimaryKeySelective(cdysc record);

    int updateByPrimaryKey(cdysc record);

    List<cdysc> selectByExampleAndPage(cdyscExample example, RowBounds rowBounds);
}