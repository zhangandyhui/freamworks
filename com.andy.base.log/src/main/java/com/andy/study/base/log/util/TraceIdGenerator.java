package com.andy.study.base.log.util;

import java.util.UUID;

public final class TraceIdGenerator {
	private static final ThreadLocal<String> traceIdSession = new ThreadLocal<String>();

	public static void setTraceId() {
		String traceId = UUID.randomUUID().toString();
		traceIdSession.set(traceId);
	}

	public static String getTraceId() {
		String traceId = traceIdSession.get();
		if (null==traceId||!"".equalsIgnoreCase(traceId)) {
			traceId = UUID.randomUUID().toString();
			traceIdSession.set(traceId);
		}
		return traceId;
	}

	public static void removeTraceId() {
		traceIdSession.remove();
	}
}