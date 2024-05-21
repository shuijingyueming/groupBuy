package com.fangx.dao;

import com.fangx.model.cdusm;
import com.fangx.model.cdusmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusmMapper {
    long countByExample(cdusmExample example);

    int deleteByExample(cdusmExample example);

    int insert(cdusm record);

    int insertSelective(cdusm record);

    List<cdusm> selectByExample(cdusmExample example);

    int updateByExampleSelective(@Param("record") cdusm record, @Param("example") cdusmExample example);

    int updateByExample(@Param("record") cdusm record, @Param("example") cdusmExample example);
}