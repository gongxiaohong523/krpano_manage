package com.example.krpano.config;

import com.example.krpano.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by wuwf on 17/4/27.
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    private final static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("execution(public * com.example.krpano.service..*.*(..))||(execution(public * com.example.krpano.controller..*(..)))")
    public void webLog(){
        log.info("切面日志拦截");
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        //log.info("方法执行前执行");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //log.info("方法的返回值 : " + JSON.toJSONString(ret));

    }

    //后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        //log.info("方法异常时执行.....  " );

    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        //log.info("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        Date startDate = new Date();

        Signature signature = pjp.getSignature();
        log.info("方法环绕start......,执行时间:"+ DateUtil.format(startDate,"yyyy-MM-dd hh:mm:ss"));
        try {
            long start = System.currentTimeMillis();
            Object o =  pjp.proceed();
            long end = System.currentTimeMillis();
            String time = formatExecuteTime(end - start);
            //log.info("方法环绕proceed，结果是 :" + JSON.toJSONString(o));
            log.info(String.format("方法签名:%s, 入参:%s, 开始执行时间:%s, 执行时间:%s", signature.toString(), Arrays.toString(args), sdf.format(startDate), time));
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    private String formatExecuteTime(long executeTime) {
        long min = (executeTime % 3600000) / 60000;
        long sec = (executeTime % 60000) / 1000;
        long msec = executeTime % 10000;
        StringBuilder sb = new StringBuilder();
        if (min > 0) {
            sb.append(min).append("m ");
        }
        if (sec > 0) {
            sb.append(sec).append("s ");
        }
        sb.append(msec).append("ms");
        return sb.toString();
    }
}