package com.fangx.dao;

import com.fangx.model.cdusb;
import com.fangx.model.cdusbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusbMapper {
    long countByExample(cdusbExample example);

    int deleteByExample(cdusbExample example);

    int deleteByPrimaryKey(Integer usb001);

    int insert(cdusb record);

    int insertSelective(cdusb record);

    List<cdusb> selectByExample(cdusbExample example);

    cdusb selectByPrimaryKey(Integer usb001);

    int updateByExampleSelective(@Param("record") cdusb record, @Param("example") cdusbExample example);

    int updateByExample(@Param("record") cdusb record, @Param("example") cdusbExample example);

    int updateByPrimaryKeySelective(cdusb record);

    int updateByPrimaryKey(cdusb record);
}