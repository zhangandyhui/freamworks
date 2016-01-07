package com.andy.study.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.andy.study.base.log.Log;
import com.andy.study.base.log.interfaces.impl.DebugLogger;

@Component
@Aspect
public class PerformanceAspect  {
	@Pointcut("execution(* com.andy.*.agent.*..*(..)))")
	public void pointcutByPackage() {
	}

	@Around(value = "pointcutByPackage()")
	public Object aroundByPackage(ProceedingJoinPoint point){
		Object retObj = null;
		String methodName = point.getSignature().getName();
		String content="";
		Object obj = point.getTarget();
		String className = obj.getClass().getSimpleName();
		long startTime = System.currentTimeMillis();
		try {
			retObj = point.proceed();
		} catch (Throwable e) {
			content=e.getMessage();
		}finally{
		 writeChecklist(methodName, className,content,System.currentTimeMillis()-startTime);
		}
		return retObj;
	}
	
	private void writeChecklist(String methodName, String className,String content,long totalTime) {
	   DebugLogger log=DebugLogger.getInstance();
	   log.setClassName(className);
	   log.setMethodName(methodName);
	   log.setTotalTime(totalTime);
	   log.setContent(content);
	   Log.write(log);
	}
}
