package com.fangx.dao;

import com.fangx.model.cdxxz;
import com.fangx.model.cdxxzExample;
import com.fangx.model.cdxxzWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdxxzMapper {
    long countByExample(cdxxzExample example);

    int deleteByExample(cdxxzExample example);

    int deleteByPrimaryKey(Integer xxz001);

    int insert(cdxxzWithBLOBs record);

    int insertSelective(cdxxzWithBLOBs record);

    List<cdxxzWithBLOBs> selectByExampleWithBLOBs(cdxxzExample example);

    List<cdxxz> selectByExample(cdxxzExample example);

    cdxxzWithBLOBs selectByPrimaryKey(Integer xxz001);

    int updateByExampleSelective(@Param("record") cdxxzWithBLOBs record, @Param("example") cdxxzExample example);

    int updateByExampleWithBLOBs(@Param("record") cdxxzWithBLOBs record, @Param("example") cdxxzExample example);

    int updateByExample(@Param("record") cdxxz record, @Param("example") cdxxzExample example);

    int updateByPrimaryKeySelective(cdxxzWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(cdxxzWithBLOBs record);

    int updateByPrimaryKey(cdxxz record);
}