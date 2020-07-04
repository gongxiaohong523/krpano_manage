package com.example.krpano.mapper.testemp;

import com.example.krpano.entity.testemp.TestEmp;

import java.util.List;

public interface TestEmpMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestEmp record);

    int insertSelective(TestEmp record);

    TestEmp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestEmp record);

    int updateByPrimaryKey(TestEmp record);

    List<TestEmp> queryAll();
}