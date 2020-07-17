package com.example.krpano.service.testemp;

import com.example.krpano.entity.testemp.TestEmpReq;
import com.example.krpano.entity.output.testemp.TestEmpResp;

import java.util.List;

public interface TestEmpService {
    List<TestEmpResp> queryAll();

    /**
     * 新增测试理顾
     * @param testEmp 入参
     * @return boolean
     */
    boolean insert(TestEmpReq testEmp);

    /**
     * 根据参数查询记录
     * @param testEmp
     * @return
     */
    TestEmpResp queryById(TestEmpReq testEmp);

}
