package org.gonnys.aop;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class NullAdvice {

	
	//proceedingJoinpoint는 리플렉션이다
	@Around("execution(* org.gonnys.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		log.info("check null...................");

		Object result = null;
		try {
			
			boolean checkNull = false;
			Object[] params = pjp.getArgs();
			for (Object object : params) {
				if(object == null) {
					throw new Exception("Null");
				}
			}
			
			
			//proceed가 invoke 실행하는 녀석
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
