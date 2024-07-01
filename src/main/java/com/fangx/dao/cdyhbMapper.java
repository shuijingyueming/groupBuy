package com.fangx.dao;

import com.fangx.model.cdyhb;
import com.fangx.model.cdyhbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdyhbMapper {
    long countByExample(cdyhbExample example);

    int deleteByExample(cdyhbExample example);

    int deleteByPrimaryKey(String yhb001);

    int insert(cdyhb record);

    int insertSelective(cdyhb record);

    List<cdyhb> selectByExample(cdyhbExample example);

    cdyhb selectByPrimaryKey(String yhb001);

    int updateByExampleSelective(@Param("record") cdyhb record, @Param("example") cdyhbExample example);

    int updateByExample(@Param("record") cdyhb record, @Param("example") cdyhbExample example);

    int updateByPrimaryKeySelective(cdyhb record);

    int updateByPrimaryKey(cdyhb record);

    cdyhb selectBygsid(Integer gsid);
}