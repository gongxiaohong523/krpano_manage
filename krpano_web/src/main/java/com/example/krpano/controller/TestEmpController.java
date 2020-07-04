package com.example.krpano.controller;

import com.example.krpano.entity.output.testemp.TestEmpResp;
import com.example.krpano.service.testemp.TestEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("testEmp")
@Slf4j
public class TestEmpController {
    @Resource
    private TestEmpService testEmpService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Callable<List<TestEmpResp>> queryAllData() {
        log.info("主线程"+Thread.currentThread().getName()+"执行开始----------执行时间=" + System.currentTimeMillis());
        Callable<List<TestEmpResp>> callable = () -> {
            log.info("副线程"+Thread.currentThread().getName()+"执行开始----------执行时间=" + System.currentTimeMillis());
            Thread.sleep(5000);
            List<TestEmpResp> list = testEmpService.queryAll();
            log.info("副线程"+Thread.currentThread().getName()+"执行结束----------执行时间=" + System.currentTimeMillis());
            return list;

        };
        log.info("主线程"+Thread.currentThread().getName()+"执行结束----------执行时间=" + System.currentTimeMillis());
        return callable;
    }


}
