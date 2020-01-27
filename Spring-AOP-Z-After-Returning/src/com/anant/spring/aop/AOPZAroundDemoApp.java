package com.anant.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anant.spring.aop.dao.AccountDAO;
import com.anant.spring.aop.service.FortuneServiceTraffic;

public class AOPZAroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AOPDemo.class);
		
		AccountDAO theDao=context.getBean("accountDAO",AccountDAO.class);
		
	
		FortuneServiceTraffic theService=context.getBean("fortuneServiceTraffic",FortuneServiceTraffic.class);
		
		System.out.println("\nCalling the Fortune Service from main app");
		
		String myFortune=theService.getFortune();
		
		System.out.println("\nFortune in main app: "+myFortune);
		
		context.close();

	}

}
