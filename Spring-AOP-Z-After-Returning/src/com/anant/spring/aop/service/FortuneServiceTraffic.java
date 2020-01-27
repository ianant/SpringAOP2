	package com.anant.spring.aop.service;
	
	import java.sql.Time;
	import java.util.concurrent.TimeUnit;
	
	import org.springframework.stereotype.Component;
	
	@Component
	public class FortuneServiceTraffic {
	
		
		
		public String getFortune() {
			
			//simulate a delay
			
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "facing heavy traffic in your good fortune";
			
		}
		
		
	}
