package com.example.krpano.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: xiaohonggong
 * @date: Created in 2020/7/12 11:46
 */
@Slf4j
@javax.servlet.annotation.WebServlet("/servlet")
public class WebServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(Thread.currentThread().getName()+" start.......");
        super.doGet(req, resp);
        try {
            buyCards();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("order successful!! ");
        log.info(Thread.currentThread().getName()+" end.......");

    }

    public void buyCards() throws InterruptedException {
        log.info(Thread.currentThread().getName()+".......");
        Thread.sleep(5000);
    }
}
