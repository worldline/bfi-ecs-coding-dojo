package com.awl.tdd.test;

import com.awl.tdd.model.Engine;

public class FakeEngine extends Engine {

	private boolean startCalled;
	private String fakeSound;

	public FakeEngine(String fakeSound) {
		this.fakeSound = fakeSound;
	}

	public String start() {
		startCalled = true;
		return fakeSound;
	}

	public boolean isStartCalled() {
		return startCalled;
	}
	
}
