package com.google.demoForIdea.threadTool;


import com.google.demoForIdea.common.ThreadPool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
@Component
@Order(-1)//保证该切面在@Transactional前执行
public class LogAspect {

	@Resource
//	private KjServerLogService kjServerLogService;

	//切入类上注解或方法上注解
	@Pointcut(value = "@annotation(com.google.demoForIdea.threadTool.Log) || @within(com.google.demoForIdea.threadTool.Log)")
	public void point(){}

	@Before("point()")
	public void before(){}

	@Around("point()")
	public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
		//开始时间
		long startTime = System.currentTimeMillis();
		//获取方法参数
		String args = AspectUtils.getInstance().bulidParams(joinPoint);
		//类
		Class clazz = joinPoint.getTarget().getClass();
		//方法
		Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();

		Object obj = joinPoint.proceed();
		//结束时间
		long endTime = System.currentTimeMillis();

		Field field = clazz.getDeclaredField("request");
		final String ip;
		final String logName;
		if(field!=null){
			field.setAccessible(true);
			HttpServletRequest request = (HttpServletRequest)field.get(joinPoint.getTarget());
		//	BasicPersonInfo personInfo = (BasicPersonInfo)request.getSession().getAttribute(SessionAttributeConstants.CURRUSER_KEY);
			ip = AspectUtils.getIpAddress(request);
		//	logName = personInfo.getLogName();
			ThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					float t = (float)(endTime-startTime)/1000;
				/*	KjServerLog log = new KjServerLog();
					log.setSuempNo(logName);//工号
					log.setLoginIp(ip);//ip
					log.setCreateTime(new Date());//创建时间
					log.setMapping(AspectUtils.getMapping(clazz,method));//访问路径
					log.setMethod(method.getName());//访问方法
					log.setArgs(args);//方法参数
					log.setRemark(null);//备注
					JSONObject object = JSONObject.fromObject(obj);
					log.setResult(object.toString());//返回结果
					log.setType(null);//日志类型
					log.setExecuteTime(t+"");//方法执行时间
					kjServerLogService.insert(log);*/
				}
			});
		}
		return obj;
	}

	@After(value = "point()")
	public void after(){}
}
