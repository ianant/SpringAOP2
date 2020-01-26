package com.anant.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.anant.spring.aop.Account;

@Aspect
@Component
@Order(2)
public class MyBeforeAspect {
	
	@AfterReturning(
			pointcut = "execution(* com.anant.spring.aop.dao.AccountDAO.listAccounts())",
			returning = "result")
	public void afterReturningAdvise(JoinPoint theJoinPoint,List<Account> result) {
		
		String methodSignature=theJoinPoint.getSignature().toShortString();
		
		System.out.println("~~~~~~~~@AfterReturning advise's method signature: "+methodSignature);
		
		System.out.println("~~~~~~~@AfterReturning account list coming from Account DAO: "+result);
		
		System.out.println("~~~~~~~@AfterReturning account list modifying it befor returning to caller");
		
		modifyResult(result);
		
	}
	
	
	

	private void modifyResult(List<Account> result) {
		
		for (Account theAccount : result) {
			
			String upperCaseName=theAccount.getName().toUpperCase();
			theAccount.setName(upperCaseName);
			
		}
		
	}




	@Before("com.anant.spring.aop.aspect.AopPointCutExpression.forDaoAdvise()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		MethodSignature mSig=(MethodSignature)theJoinPoint.getSignature();
				
		System.out.println("::::>>>>>>>>>>Aspect before calling DAO method");
		
		System.out.println("::::>>>>>>>>>>Method Signature-- "+mSig);
		
		//display the method arguments
		
		Object[] methodArgs=theJoinPoint.getArgs();
		for (Object argsOfMethod : methodArgs) {
			System.out.println("::::>>>>>>>>>>Method Arguments : "+argsOfMethod);
		}
	}	
	
}
