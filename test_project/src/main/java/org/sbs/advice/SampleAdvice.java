package org.sbs.advice;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;  // 이걸로 추출
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 추가
@Aspect    // 추가
public class SampleAdvice {   
         //point cut 지정
   
   @Before("execution(* org.sbs.persistence.BoardDAO*.*(..))")
   public void ready(JoinPoint jp){   
	   
	   System.out.println("Start Ready");
	   // 인터셉터와 filter는 유사한 개념...
	   // 목적 객체
	   System.out.println(jp.getTarget());
	   // 전달하는 파라미터
	   System.out.println(jp.getArgs());
	   // 호출하려는 메소드 객체
	   System.out.println(jp.getSignature());
	   
   }
   
   //어라운드는 범용성이 높다... 오브젝트로 리턴하자
   @Around("execution(* org.sbs.persistence.BoardDAO*.*(..))")
   public Object rest(ProceedingJoinPoint pjp) throws Throwable{
      
      System.out.println("start..............");
      long start = System.currentTimeMillis();
      
      Object returnValue = pjp.proceed(); // 직접 메소드의 실행을 제어 할 수 있다.
      
      long end = System.currentTimeMillis();
      
      System.out.println("end..................");
      System.out.println("TIME: "+(end-start));      
      
      return returnValue;
      // 쿼리등에서 기록을 사용해서 문제 있는 점을 따로 관리 할 수 있다. 시스템 모니터링 
   }
}