package com.wang.serviceimpl;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Service;

@Service("advisorService")
public class AdvisorServiceImpl implements AfterReturningAdvice, MethodBeforeAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行afterReturning。。。。。");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行beforeReturning。。。。。");

	}

}
