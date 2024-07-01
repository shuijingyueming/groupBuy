package com.fangx.dao;

import com.fangx.model.cdusn;
import com.fangx.model.cdusnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusnMapper {
    long countByExample(cdusnExample example);

    int deleteByExample(cdusnExample example);

    int deleteByPrimaryKey(Integer usn001);

    int insert(cdusn record);

    int insertSelective(cdusn record);

    List<cdusn> selectByExample(cdusnExample example);

    cdusn selectByPrimaryKey(Integer usn001);

    int updateByExampleSelective(@Param("record") cdusn record, @Param("example") cdusnExample example);

    int updateByExample(@Param("record") cdusn record, @Param("example") cdusnExample example);

    int updateByPrimaryKeySelective(cdusn record);

    int updateByPrimaryKey(cdusn record);

    cdusn selectBycpid(Integer usn001);
}