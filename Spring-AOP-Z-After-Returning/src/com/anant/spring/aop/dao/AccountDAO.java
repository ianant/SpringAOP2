package com.anant.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anant.spring.aop.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount,boolean flag) {
		System.out.println("\nHello! Spring AOP");
	}

	public List<Account> listAccounts(){

	List<Account> myAccounts=new ArrayList<>();
	Account temp1=new Account("Beginner", "Anant");
	Account temp2=new Account("Pro", "Rahul");
	Account temp3=new Account("Ultra Pro","Ashu");
	
	myAccounts.add(temp1);
	myAccounts.add(temp2);
	myAccounts.add(temp3);
	
	return myAccounts;
	
	
	
	}
	
	public void myAccount() {
		System.out.println("\nAccount dao using myAccount method");
	}
}
