package org.gonnys.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class LogAdvice {

	@Before("execution(* org.gonnys.service.SampleService*.*(String,String)) && args(str1,str2)")
	public void logBefore(String str1, String str2) {
		
		log.info("=====================1========================" + str1);
		log.info("=========================2===================" + str2);
		log.info("===========3==================================");
		log.info("===============================4==============");
		log.info("=================5============================");
		log.info("==========================6===================");
		
	}
	
	@AfterReturning("execution(* org.gonnys.service.SampleService*.*(..))")
	public void logAfter() {
		
		log.info("*******1******************************");
		log.info("*************************2************");
		log.info("****************3********************");
		log.info("*****************************4*******");
		log.info("****5*********************************");
		
		
	}
	
}
