package com.andy.study.base.log.interfaces.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andy.study.base.log.interfaces.ILog;
import com.andy.study.base.log.util.LogFormatter;
import com.andy.study.base.log.util.TraceIdGenerator;

/**
 * Description: 
 * Date:2015年12月29日 
 * Author:ZhangHui
 */
public class DebugLogger implements ILog {
	private final static Logger logger = LoggerFactory.getLogger("debugLogger");

    private DebugLogger(){
    }
    public static DebugLogger getInstance(){
        return new DebugLogger();
    }
	
	private String className;
	private String methodName;
    private long totalTime;
	private String content;

	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Logger getLogger() {
		return logger;
	}

	public String format() {
		StringBuilder sb = new StringBuilder();
		sb.append(LogFormatter.DATE_FORMAT.format(System.currentTimeMillis()));
		sb.append(LogFormatter.FIELD_SPLIT);
		sb.append(TraceIdGenerator.getTraceId());
		sb.append(LogFormatter.FIELD_SPLIT);
		sb.append(getClassName());
		sb.append(LogFormatter.FIELD_SPLIT);
		sb.append(getMethodName());
		sb.append(LogFormatter.FIELD_SPLIT);
		sb.append(getContent());
		sb.append(LogFormatter.FIELD_SPLIT);
		sb.append(getTotalTime());
		sb.append("\n");
		return sb.toString();
	}
}
