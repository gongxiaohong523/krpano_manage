package com.example.krpano.service.testemp;

import com.example.krpano.entity.testemp.TestEmp;
import com.example.krpano.entity.testemp.TestEmpReq;
import com.example.krpano.entity.output.testemp.TestEmpResp;
import com.example.krpano.hander.testemp.TestEmpHandler;
import com.example.krpano.util.ProviderEntityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TestEmpServiceImpl implements TestEmpService {

    @Resource
    private TestEmpHandler testEmpHandler;

    /**
     * 查询所有客户信息List
     *
     * @return List
     */
    public List<TestEmpResp> queryAll() {
        List<TestEmpResp> testEmpResps = new ArrayList<>();
        try {
            List<TestEmp> testEmps = testEmpHandler.queryAll();
            for (TestEmp testEmp : testEmps) {
                TestEmpResp testEmpResp = new TestEmpResp();
                BeanUtils.copyProperties(testEmp, testEmpResp);
                testEmpResps.add(testEmpResp);
            }
        } catch (Exception e) {
            log.error("查询所有客户信息List异常", e);
        }
        return testEmpResps;

    }

    /**
     * 新增测试理顾
     *
     * @param testEmpReq 入参
     * @return boolean
     */
    @Override
    public boolean insert(TestEmpReq testEmpReq) {
        boolean flag = false;
        try {
            TestEmp testEmp = new TestEmp();
            BeanUtils.copyProperties(testEmpReq, testEmp);
            flag = testEmpHandler.insertRecord(testEmp);
        } catch (Exception e) {
            log.error("新增测试理顾异常", e);
        }
        return flag;
    }
    /**
     * 根据参数查询记录
     * @param testEmpReq
     * @return
     */
    @Override
    public TestEmpResp queryById(TestEmpReq testEmpReq) {
        TestEmpResp testEmpResp = new TestEmpResp();
        try {
            TestEmp testEmp = testEmpHandler.selectById(testEmpReq);
            testEmpResp = ProviderEntityUtil.convertEntity2Resp(testEmp);
        } catch (Exception e) {
            log.error("新增测试理顾异常", e);
        }
        return testEmpResp;
    }
}
