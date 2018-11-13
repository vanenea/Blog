package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.blog.model.TContents;
import com.blog.model.TContentsExample;

@Mapper
public interface TContentsMapper {
    int countByExample(TContentsExample example);

    int deleteByExample(TContentsExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TContents record);

    int insertSelective(TContents record);

    List<TContents> selectByExampleWithBLOBs(TContentsExample example);

    List<TContents> selectByExample(TContentsExample example);

    TContents selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TContents record, @Param("example") TContentsExample example);

    int updateByExampleWithBLOBs(@Param("record") TContents record, @Param("example") TContentsExample example);

    int updateByExample(@Param("record") TContents record, @Param("example") TContentsExample example);

    int updateByPrimaryKeySelective(TContents record);

    int updateByPrimaryKeyWithBLOBs(TContents record);

    int updateByPrimaryKey(TContents record);
}