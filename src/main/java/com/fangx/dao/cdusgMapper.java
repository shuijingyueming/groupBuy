package com.fangx.dao;

import com.fangx.model.cdusg;
import com.fangx.model.cdusgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cdusgMapper {
    long countByExample(cdusgExample example);

    int deleteByExample(cdusgExample example);

    int deleteByPrimaryKey(String usg001);

    int insert(cdusg record);

    int insertSelective(cdusg record);

    List<cdusg> selectByExample(cdusgExample example);

    cdusg selectByPrimaryKey(String usg001);

    int updateByExampleSelective( cdusg record, @Param("example") cdusgExample example);

    int updateByExample(@Param("record") cdusg record, @Param("example") cdusgExample example);

    int updateByPrimaryKeySelective(cdusg record);

    int updateByPrimaryKey(cdusg record);

    cdusg selectBygsid(@Param("cpid")Integer cpid,@Param("gsid")Integer gsid);
}