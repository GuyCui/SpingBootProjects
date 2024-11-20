package com.leo.architecture.a_original.servlet;

import com.leo.architecture.a_original.service.DemoService;
import com.leo.architecture.a_original.service.impl.DemoServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    DemoService demoService = new DemoServiceImpl();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(demoService.findAll().toString());
    }
}
