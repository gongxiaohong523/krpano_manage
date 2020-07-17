package com.example.krpano.controller;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @description:
 * @author: xiaohonggong
 * @date: Created in 2020/7/11 15:34
 */
public class RequestQuene {

    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedDeque<DeferredResult<Object>>();

    public static Integer getQueueLength(){
        return queue.size();
    }
    public static void save(DeferredResult<Object> deferredResult) {
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> poll() {
        return queue.poll();
    }
}
