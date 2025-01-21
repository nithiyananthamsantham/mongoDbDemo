package com.chirohi.mongodemo.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
		
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AopLoggingAdvice {
	
	@Pointcut("execution(* com.chirohi.mongodemo.postgres.service.JWTAuthenticateService.*(..))")
	private void logPointCut() {
		
	}
	
	@Before("logPointCut()")
	public void logRequest(JoinPoint joinPoint) throws JsonProcessingException {
		
		log.info("Before Advice class name: "+joinPoint.getTarget());
		log.info("Before Advice method name: "+joinPoint.getSignature().getName());
		log.info("Before Advice request body: "+new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
	}
	
////	@After("logPointCut()")
//	@After(value = "execution(* com.chirohi.mongodemo.postgres.service.JWTAuthenticateService.*(..))")
//	public void logResponse(JoinPoint joinPoint) throws JsonProcessingException {
//		
//		log.info("After Advice class name: "+joinPoint.getTarget());
//		log.info("After Advice method name: "+joinPoint.getSignature().getName());
//		log.info("After Advice request body: "+new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
//	}
	
	@AfterReturning(value = "execution(* com.chirohi.mongodemo.postgres.service.JWTAuthenticateService.*(..))")
	public void logResponseReturn(JoinPoint joinPoint) throws JsonProcessingException {
		
		log.info("After Advice class name: "+joinPoint.getTarget());
		log.info("After Advice method name: "+joinPoint.getSignature().getName());
		log.info("After Advice request body: "+new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
	}
	
//	@AfterThrowing("logPointCut()")
	@AfterThrowing(value = "execution(* com.chirohi.mongodemo.postgres.service.JWTAuthenticateService.*(..))")
	public void logError(JoinPoint joinPoint) throws JsonProcessingException {
		
		log.info("After Throwing Advice class name: "+joinPoint.getTarget());
		log.info("After Throwing Advice method name: "+joinPoint.getSignature().getName());
		log.info("After Throwing Advice request body: "+new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
	}
	

}
