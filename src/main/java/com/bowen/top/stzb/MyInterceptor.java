package com.bowen.top.stzb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	private  final Logger log = LoggerFactory.getLogger(getClass()); 
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>MyInterceptor1>>>>>>>preHandle在请求处理之前进行调用（Controller方法调用之前）");
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
        log.info(">>>MyInterceptor1>>>>>>>postHandle请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）.");
        if (modelAndView != null) {
            log.info("ViewName:{}", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        log.info(">>>MyInterceptor1>>>>>>>afterCompletion.在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
