package com.example.krpano.service.testemp;

import com.alibaba.fastjson.JSON;
import com.example.krpano.entity.testemp.TestEmpReq;
import com.example.krpano.entity.output.testemp.TestEmpResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.Resource;
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
    public void testAdd() {
        try {
            TestEmpReq testEmpReq = new TestEmpReq();
            testEmpReq.setAge(34l);
            testEmpReq.setId(34L);
            testEmpReq.setName("测试事务");
            Boolean flag = testEmpService.insert(testEmpReq);
            log.info(JSON.toJSONString(flag));
        } catch (Exception e) {
            log.error("数据测试异常", e);
        }
    }


}
