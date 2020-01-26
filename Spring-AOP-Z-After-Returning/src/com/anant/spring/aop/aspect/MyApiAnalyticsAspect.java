package com.anant.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.anant.spring.aop.aspect.AopPointCutExpression.forDaoAdvise()")
	public void performAPIANalyticsAdvise() {
		System.out.println("::::>>>>>>>>>>Calling the API");
	}
}
