package com.google.demoForIdea.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class 定时任务 {
	private int count=0;
	@Scheduled(cron="*/6 * * * * ?")
	private void process(){
		System.out.println("this is scheduler task runing  "+(count++));
	}
}
