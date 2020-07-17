package com.example.krpano.controller;

import com.example.krpano.entity.output.testemp.TestEmpResp;
import com.example.krpano.service.testemp.TestEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
@RequestMapping("testEmp")
@Slf4j
public class TestEmpController {
    @Resource
    private TestEmpService testEmpService;

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @RequestMapping("/queryAll")
    @ResponseBody
    public Callable<List<TestEmpResp>> queryAllData() {
       // log.info("主线程" + Thread.currentThread().getName() + "执行开始----------执行时间=" + System.currentTimeMillis());
        Callable<List<TestEmpResp>> callable = () -> {
           // log.info("副线程" + Thread.currentThread().getName() + "执行开始----------执行时间=" + System.currentTimeMillis());
            //Thread.sleep(5000);
            List<TestEmpResp> list = testEmpService.queryAll();
           // log.info("副线程" + Thread.currentThread().getName() + "执行结束----------执行时间=" + System.currentTimeMillis());
            return list;

        };
      //  log.info("主线程" + Thread.currentThread().getName() + "执行结束----------执行时间=" + System.currentTimeMillis());
        return callable;
    }


    @RequestMapping("/createOrder")
    @ResponseBody
    public DeferredResult<Object> createOrder() {
        DeferredResult<Object> deferredResult = new DeferredResult<Object>(60000l, "create order fail...");
        RequestQuene.save(deferredResult);
        return deferredResult;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Object get() {
        UUID uuid = UUID.randomUUID();
        log.info("取值之前 queue size = "+ RequestQuene.getQueueLength());
        DeferredResult<Object> deferredResult = RequestQuene.poll();
        if(null != deferredResult){
            deferredResult.setResult("queue size = "+RequestQuene.getQueueLength()+" hello world ,create SUCCESS,orderiD = " + uuid.toString());
            //RequestQuene.save(deferredResult);
            log.info("设值之后 queue size = "+ RequestQuene.getQueueLength());
            return deferredResult.getResult();
        }
        return "queue size = "+RequestQuene.getQueueLength()+"=====>>>get null orderRequest";

    }






}
