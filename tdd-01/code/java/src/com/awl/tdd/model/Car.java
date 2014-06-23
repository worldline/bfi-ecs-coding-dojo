package com.awl.tdd.model;

public class Car {

	private Engine engine;

	public Car(Engine engine) {
		this.engine = engine;
	}

	public String start() {
		return engine.start();
	}

}
