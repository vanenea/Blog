package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.model.TRelationshipsExample;
import com.blog.model.TRelationshipsKey;

public interface TRelationshipsMapper {
    int countByExample(TRelationshipsExample example);

    int deleteByExample(TRelationshipsExample example);

    int deleteByPrimaryKey(TRelationshipsKey key);

    int insert(TRelationshipsKey record);

    int insertSelective(TRelationshipsKey record);

    List<TRelationshipsKey> selectByExample(TRelationshipsExample example);

    int updateByExampleSelective(@Param("record") TRelationshipsKey record, @Param("example") TRelationshipsExample example);

    int updateByExample(@Param("record") TRelationshipsKey record, @Param("example") TRelationshipsExample example);
}