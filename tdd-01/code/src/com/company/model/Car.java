package com.company.model;

/**
 * @author Olivier PEREZ
 */
public class Car {

	private Engine engine;
	
	private Alarm alarm;

	public Car (final Engine engine) {
		this.engine = engine;
	}

	public void setAlarm(final Alarm alarm) {
		this.alarm = alarm;
	}

	public String start() {
		return engine.start();
	}
}
