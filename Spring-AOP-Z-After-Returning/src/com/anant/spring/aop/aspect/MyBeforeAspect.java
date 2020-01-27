package com.anant.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.anant.spring.aop.service.*.getFortune(..))")
	public Object aroundAdviseExecution(ProceedingJoinPoint thePJoinPoint)throws Throwable{
		
		//print out method we are advising on
		String methodSig=thePJoinPoint.getSignature().toShortString();
		System.out.println("~~~~~~~~ Method on which @Around is applied: "+methodSig);
		
		//get begin time stamp
		
		long start=System.currentTimeMillis();
		
		//execute the method		
		
		Object result=null;
		
		
		try {
			//this will call the method on which @Advice should be applied
			thePJoinPoint.proceed();
		} catch (Exception e) {
			
			//log the exception
			System.out.println("~~~~~~~~~~~Exception occured in good fortune"+e);
			
			//give user a custom message
			//result="~~~~~~~~~dont't worry Bholenath is there for you:::";
			
			throw e;
		}
		
		//get the ending time stamp
		
		long end=System.currentTimeMillis();
		
		//compute and display the duration
		
		long delay=end-start;
		
		System.out.println("~~~~~~~~~ delay in the method due to traffic: "+delay/1000 +" sec");
		
		
		return result;
		
		
	}

	
	
	
	@After("execution(* com.anant.spring.aop.dao.AccountDAO.listAccounts(..))")
	public void afterFinallyAdviseExecution(JoinPoint theJoinPoint) {
		 
		String methodSig=theJoinPoint.getSignature().toShortString();
		
		System.out.println("~~~~~~~~executing after (finally) advise regardless of the outcome of targetObject method");
		
	}
	
	
	@AfterThrowing(pointcut="execution(* com.anant.spring.aop.dao.AccountDAO.listAccounts(..))",
			throwing = "theExc")
	public void afterThrowingListAccountAdvise(JoinPoint theJoinPoint,Throwable theExc) {
		
		//print out whic method we are advising on
		
		String theMethod=theJoinPoint.getSignature().toShortString();
		System.out.println("~~~~~~~~@AfterThrowing method signature : "+theMethod);
				
		
		//log the exception before returning to main application
		
		System.out.println("~~~~~~~~Exception coming from AccountDAO's listAccount()"+theExc);
		
	}
	
	
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
