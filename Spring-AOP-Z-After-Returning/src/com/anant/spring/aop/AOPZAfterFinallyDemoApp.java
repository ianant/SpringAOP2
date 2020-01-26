package com.anant.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anant.spring.aop.dao.AccountDAO;

public class AOPZAfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AOPDemo.class);
		
		AccountDAO theDao=context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts=null;
		
		try {
			theAccounts=theDao.listAccounts(true);
		}
		catch(Exception exc){
			System.out.println("\nExecptionOccured for after throwing");
		}
		
		System.out.println("\n\nMain demo app account list: "+theAccounts);
		context.close();

	}

}
