package com.anant.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class AopPointCutExpression {

	@Pointcut("execution(* com.anant.spring.aop.dao.*.*(..))")
	public void forDaoAdvise() {	}

}
