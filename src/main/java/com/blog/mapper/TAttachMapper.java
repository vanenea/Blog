package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.model.TAttach;
import com.blog.model.TAttachExample;


public interface TAttachMapper {
    int countByExample(TAttachExample example);

    int deleteByExample(TAttachExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAttach record);

    int insertSelective(TAttach record);

    List<TAttach> selectByExample(TAttachExample example);

    TAttach selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAttach record, @Param("example") TAttachExample example);

    int updateByExample(@Param("record") TAttach record, @Param("example") TAttachExample example);

    int updateByPrimaryKeySelective(TAttach record);

    int updateByPrimaryKey(TAttach record);
}