package com.example.krpano.service.testemp;

import com.alibaba.fastjson.JSON;
import com.example.krpano.entity.testemp.TestEmpReq;
import com.example.krpano.entity.output.testemp.TestEmpResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@TestPropertySource("classpath:application.properties")
public class TestEmpServiceTest extends BaseSpringTest {


    @Resource
    private TestEmpService testEmpService;

    @Test
    public void test01() {
        try {
            List<TestEmpResp> testEmpRespList = testEmpService.queryAll();
            log.info(JSON.toJSONString(testEmpRespList));
        } catch (Exception e) {
            log.error("数据测试异常", e);
        }
    }

    @Test
    @Transactional
    public void testAdd() {
        try {
            TestEmpReq testEmpReq = new TestEmpReq();
            testEmpReq.setAge(34l);
            testEmpReq.setId(36l);
            testEmpReq.setName("测试事务");

            TestEmpReq testEmpReq2 = new TestEmpReq();
            testEmpReq2.setAge(34l);
            testEmpReq2.setId(36l);
            testEmpReq2.setName("测试事务");
            List<TestEmpReq> testEmpReqs = new ArrayList<>();
            testEmpReqs.add(testEmpReq);
            testEmpReqs.add(testEmpReq2);
            for (TestEmpReq req : testEmpReqs) {
                TestEmpResp testEmpResp = testEmpService.queryById(req);
                if (testEmpResp == null) {
                    Boolean flag = testEmpService.insert(testEmpReq);
                }
            }
            //testEmpService.queryById(testEmpReq);
            //log.info(JSON.toJSONString(flag));
        } catch (Exception e) {
            log.error("数据测试异常", e);
        }
    }

    @Test
    public void testInsert() {
        try {
            TestEmpReq testEmpReq = new TestEmpReq();
            testEmpReq.setAge(34l);
            testEmpReq.setId(99l);
            testEmpReq.setName("测试事务");

            testEmpService.insert(testEmpReq);
            //testEmpService.queryById(testEmpReq);
            //log.info(JSON.toJSONString(flag));
        } catch (Exception e) {
            log.error("数据测试异常", e);
            throw new RuntimeException("新增异常");
        }
    }


}
