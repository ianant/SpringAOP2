package com.anant.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAspect {

	@Before("com.anant.spring.aop.aspect.AopPointCutExpression.forDaoAdvise()")
	public void logToCloud(JoinPoint theJointPoint) {
		
		MethodSignature mSig=(MethodSignature) theJointPoint.getSignature();
		System.out.println("::::>>>>>>>>>>Calling the log cloud"); 
		System.out.println("::::>>>>>>>>>>Method Signature: "+mSig);
	}
}
