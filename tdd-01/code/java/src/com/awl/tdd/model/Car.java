package com.awl.tdd.model;

public class Car {

    private Engine engine;
    private final String fingerprint;

    public Car(Engine engine, String fingerprint) {
        this.engine = engine;
        this.fingerprint = fingerprint;
    }

    public String start(Key key) {
        if (key != null && isKeyValid(key)) {
            return engine.start();
        } else {
            return "";
        }
    }

    private boolean isKeyValid(Key key) {
        return fingerprint.equals(key.getFingerprint());
    }

}
