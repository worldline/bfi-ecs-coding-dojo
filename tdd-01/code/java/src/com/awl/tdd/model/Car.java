package com.awl.tdd.model;

public class Car {

    private Engine engine;
    private final String fingerprint;
    private Alarm alarm;

    public Car(Engine engine, String fingerprint) {
        this.engine = engine;
        this.fingerprint = fingerprint;
    }

    public String start(Key key) {
        if (key == null) {
            return callAlarm();

        } else if (fingerprint.equals(key.getFingerprint())) {
            return engine.start();

        } else {
            return "";
        }
    }

    private String callAlarm() {
        return alarm != null ? alarm.makeNoise() : "";
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

}
