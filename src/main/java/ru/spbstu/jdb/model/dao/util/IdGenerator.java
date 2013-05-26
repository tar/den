package ru.spbstu.jdb.model.dao.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
	private AtomicInteger _id = new AtomicInteger();
	private int _delta;

	public IdGenerator(int start, int delta) {
		_id.set(start);
		_delta = delta;
	}

	public int getNextId() {
		return _id.addAndGet(_delta);
	}
}
