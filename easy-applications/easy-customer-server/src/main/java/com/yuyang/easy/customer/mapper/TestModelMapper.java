package com.yuyang.easy.customer.mapper;

import com.yuyang.easy.common.entity.customer.model.TestModel;

import java.util.List;

public interface TestModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestModel record);

    int insertSelective(TestModel record);

    TestModel selectByPrimaryKey(Long id);

    List<TestModel> selectByPage();

    int updateByPrimaryKeySelective(TestModel record);

    int updateByPrimaryKey(TestModel record);
}