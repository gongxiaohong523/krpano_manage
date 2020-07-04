package com.example.krpano.hander.testemp;

import com.example.krpano.entity.testemp.TestEmp;
import com.example.krpano.mapper.testemp.TestEmpMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestEmpHandler {

    @Resource
    private TestEmpMapper testEmpMapper;

    /**
     * 查询所有用户
     *
     * @return List
     */
    public List<TestEmp> queryAll() {
        List<TestEmp> testEmps = new ArrayList<>();
        try {
            testEmps = testEmpMapper.queryAll();
        } catch (Exception e) {
            log.error("查询所有用户异常", e);
        }
        return testEmps;

    }

    /**
     * 新增测试数据
     *
     * @param testEmp 入参
     * @return boolean
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean insertRecord(TestEmp testEmp) {
        int insertRecord = testEmpMapper.insert(testEmp);
        int updateRecord = 1/0;
        return insertRecord > 0;

    }
}
