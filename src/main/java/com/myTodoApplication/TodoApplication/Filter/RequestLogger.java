package com.myTodoApplication.TodoApplication.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
@Slf4j
public class RequestLogger implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        long startTime = System.currentTimeMillis();

        String method = httpServletRequest.getMethod();
        String uri = httpServletRequest.getRequestURI();

        filterChain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        log.info(String.format("[Request] %s %s | Took: %d ms%n", method, uri, duration));

    }
}
