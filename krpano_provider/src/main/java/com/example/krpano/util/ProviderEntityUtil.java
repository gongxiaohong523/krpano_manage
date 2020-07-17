package com.example.krpano.util;

import com.example.krpano.entity.output.testemp.TestEmpResp;
import com.example.krpano.entity.testemp.TestEmp;

/**
 * @description:
 * @author: xiaohonggong
 * @date: Created in 2020/7/14 16:20
 */
public class ProviderEntityUtil {
    public static TestEmpResp convertEntity2Resp(TestEmp testEmp) {
        if (testEmp == null) {
            return null;
        }
        TestEmpResp testEmpResp = new TestEmpResp();
        testEmpResp.setId(testEmp.getId());
        testEmpResp.setName(testEmp.getName());
        testEmpResp.setAge(testEmp.getAge());
        return testEmpResp;
    }
}
