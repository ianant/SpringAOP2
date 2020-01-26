package com.anant.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anant.spring.aop.dao.AccountDAO;

public class AOPZAfterReturningDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AOPDemo.class);
		
		AccountDAO theDao=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts=theDao.listAccounts(false);
		
		System.out.println("\n\nMain demo app account list: "+theAccounts);
		context.close();

	}

}
