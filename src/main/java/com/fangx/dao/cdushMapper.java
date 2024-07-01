package com.fangx.dao;

import com.fangx.model.cdush;
import com.fangx.model.cdushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdushMapper {
    long countByExample(cdushExample example);

    int deleteByExample(cdushExample example);

    int deleteByPrimaryKey(String ush001);

    int insert(cdush record);

    int insertSelective(cdush record);

    List<cdush> selectByExample(cdushExample example);

    cdush selectByPrimaryKey(String ush001);

    int updateByExampleSelective(@Param("record") cdush record, @Param("example") cdushExample example);

    int updateByExample(@Param("record") cdush record, @Param("example") cdushExample example);

    int updateByPrimaryKeySelective(cdush record);

    int updateByPrimaryKey(cdush record);

    cdush selectByddid(String ush001);

    Integer selectByyhdd(@Param("yhid")Integer yhid, @Param("qsid")String qsid);

    List<cdush> selectByExample1(cdushExample e1);

    Integer selectBycg(String qsid);
}