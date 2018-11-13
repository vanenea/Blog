package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.blog.model.TLogs;
import com.blog.model.TLogsExample;

@Mapper
public interface TLogsMapper {
    int countByExample(TLogsExample example);

    int deleteByExample(TLogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLogs record);

    int insertSelective(TLogs record);

    List<TLogs> selectByExample(TLogsExample example);

    TLogs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLogs record, @Param("example") TLogsExample example);

    int updateByExample(@Param("record") TLogs record, @Param("example") TLogsExample example);

    int updateByPrimaryKeySelective(TLogs record);

    int updateByPrimaryKey(TLogs record);
}