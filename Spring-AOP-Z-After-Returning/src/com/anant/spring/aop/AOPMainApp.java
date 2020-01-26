package com.anant.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anant.spring.aop.dao.AccountDAO;
import com.anant.spring.aop.dao.MemberShipDAO;

public class AOPMainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AOPDemo.class);
		
		AccountDAO theDao=context.getBean("accountDAO",AccountDAO.class);
		
		MemberShipDAO theMemberDao=context.getBean("memberShipDAO",MemberShipDAO.class);
		
		//theMemberDao.addAccount();
		
		Account myAccount=new Account();
		myAccount.setName("Anant");
		myAccount.setLevel("Learner");
		theDao.addAccount(myAccount,true);
		theDao.myAccount();
		
		theMemberDao.addAccount();
		theMemberDao.memberShip();
		
		context.close();

	}

}
