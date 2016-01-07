package com.andy.study.base.log;

import org.junit.Test;

import com.andy.study.base.log.interfaces.impl.DebugLogger;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest   extends TestCase
{
	@Test
	public void testLog(){
		DebugLogger debugLogger = DebugLogger.getInstance();
		debugLogger.setClassName("clzName");
		debugLogger.setContent("Content aaaaa");
		debugLogger.setMethodName("Method aaaaa");
		Log.write(debugLogger);
	}
}
