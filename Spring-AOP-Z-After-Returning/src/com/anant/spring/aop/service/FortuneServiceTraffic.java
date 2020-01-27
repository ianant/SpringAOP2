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

		public String getFortune(boolean triggerExecption) {
			// TODO Auto-generated method stub
			if(triggerExecption) {
				throw new RuntimeException("Issue in getFortuneService : don't take it");
			}
			return getFortune();
		}
		
		
	}
