package com.fangx.dao;

import com.fangx.model.cdysd;
import com.fangx.model.cdysdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdysdMapper {
    long countByExample(cdysdExample example);

    int deleteByExample(cdysdExample example);

    int deleteByPrimaryKey(Integer ysd001);

    int insert(cdysd record);

    int insertSelective(cdysd record);

    List<cdysd> selectByExample(cdysdExample example);

    cdysd selectByPrimaryKey(Integer ysd001);

    int updateByExampleSelective(@Param("record") cdysd record, @Param("example") cdysdExample example);

    int updateByExample(@Param("record") cdysd record, @Param("example") cdysdExample example);

    int updateByPrimaryKeySelective(cdysd record);

    int updateByPrimaryKey(cdysd record);

    cdysd selectBypsid(Integer id);
}