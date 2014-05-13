package com.company.model;

/**
 * @author Olivier PEREZ
 */
public class Car {

    private Engine engine;

    private Alarm alarm;

    private Key expectedKey;

    public Car(final Key expectedKey, final Engine engine) {
        this.engine = engine;
        this.expectedKey = expectedKey;
    }

    public void setAlarm(final Alarm alarm) {
        this.alarm = alarm;
    }

    public String start(final Key key) {
        if (key != null && expectedKey.equals(key)) {
            return engine.start();
        }
        return null;
    }
}
