package com.anant.spring.aop;


import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anant.spring.aop.dao.AccountDAO;
import com.anant.spring.aop.service.FortuneServiceTraffic;

public class AOPZAroundDemoApp {

	private static Logger myLogger=Logger.getLogger(AOPZAroundDemoApp.class.getName());
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AOPDemo.class);
		
		AccountDAO theDao=context.getBean("accountDAO",AccountDAO.class);
		
	
		FortuneServiceTraffic theService=context.getBean("fortuneServiceTraffic",FortuneServiceTraffic.class);
		
		myLogger.info("\nCalling the Fortune Service from main app");
		
		String myFortune=theService.getFortune();
		
		myLogger.info("\nFortune in main app: "+myFortune);
		
		context.close();

	}

}
