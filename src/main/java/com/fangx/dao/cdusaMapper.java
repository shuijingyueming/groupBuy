package com.fangx.dao;

import com.fangx.model.cdusa;
import com.fangx.model.cdusaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusaMapper {
    long countByExample(cdusaExample example);

    int deleteByExample(cdusaExample example);

    int deleteByPrimaryKey(Integer usa001);

    int insert(cdusa record);

    int insertSelective(cdusa record);

    List<cdusa> selectByExample(cdusaExample example);

    cdusa selectByPrimaryKey(Integer usa001);

    int updateByExampleSelective(@Param("record") cdusa record, @Param("example") cdusaExample example);

    int updateByExample(@Param("record") cdusa record, @Param("example") cdusaExample example);

    int updateByPrimaryKeySelective(cdusa record);

    int updateByPrimaryKey(cdusa record);
}