package com.andy.study.base.cache.interfaces.impl;

public class GetReadRedisNumSingleton {

	private static int next = 0;

	private GetReadRedisNumSingleton() {
	}

	public synchronized static int getNumber(int count) {

		next++;
		if (next >= count) {
			next = 0;
		}

		return next;
	}

}