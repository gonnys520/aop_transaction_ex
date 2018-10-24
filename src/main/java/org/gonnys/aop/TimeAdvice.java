package org.gonnys.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class TimeAdvice {

	@Around("execution(* org.gonnys.service.*.*(..))")
	public Object checkTime(ProceedingJoinPoint pjp) {
		Object result = null;
		long start = System.currentTimeMillis();
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total:" + (end - start));
		
		return result;
	}
}
