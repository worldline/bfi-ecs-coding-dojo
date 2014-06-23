package com.awl.tdd;

import com.awl.tdd.model.Car;
import com.awl.tdd.model.Engine;
import com.awl.tdd.model.Key;
import com.awl.tdd.test.FakeEngine;

public class Main {

    public static void main(String[] args) {
        // Unit
        should_start_engine(); // Step 1
        should_start_engine_when_starting_car(); // Step 1 and 2
        should_not_start_car_without_key(); // Step 2
        should_not_start_car_with_worng_keys(); // Step 2

        // Integration
        INTEGRATION_should_start_car(); // Step 1
    }

    /* Unit tests */

    private static void should_start_engine() {
        // Given
        Engine engine = new Engine();

        // When
        String sound = engine.start();

        // Then
        checkEquals("Engine should start", "vrooom", sound);
    }

    private static void should_start_engine_when_starting_car() {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Car car = new Car(fakeEngine, "AZERTYUIOP");
        Key key = new Key("AZERTYUIOP");

        // When
        String sound = car.start(key);

        // Then
        checkTrue("Starting car should start engine", fakeEngine.isStartCalled());
        checkEquals("Car should do the same song as engine", "tagazoo", sound);
    }

    private static void should_not_start_car_without_key() {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Car car = new Car(fakeEngine, "AZERTYUIOP");

        // When
        String sound = car.start(null);

        // Then
        checkFalse("Starting car should not start engine without key", fakeEngine.isStartCalled());
        checkEquals("Car should mute when starting without key", "", sound);
    }

    private static void should_not_start_car_with_worng_keys() {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Car car = new Car(fakeEngine, "AZERTYUIOP");
        Key key = new Key("POIUYTREZA");

        // When
        String sound = car.start(key);

        // Then
        checkFalse("Starting car should not start engine with wrong keys", fakeEngine.isStartCalled());
        checkEquals("Car should mute when starting with wrong keys", "", sound);
    }

    /* Integration tests */

    private static void INTEGRATION_should_start_car() {
        // Given
        Car car = new Car(new Engine(), "AZERTYUIOP");
        Key key = new Key("AZERTYUIOP");

        // When
        String sound = car.start(key);

        // Then
        checkEquals("Car should start", "vrooom", sound);
    }

    /**
     * Check that condition is respected.
     *
     * @param message
     * @param condition
     */
    private static void checkTrue(String message, boolean condition) {
        if (condition) {
            System.out.println("OK - " + message);
        } else {
            System.out.println("Fail - " + message);
        }
    }

    /**
     * Check that condition is NOT respected.
     *
     * @param message
     * @param condition
     */
    private static void checkFalse(String message, boolean condition) {
        checkTrue(message, !condition);
    }

    /**
     * Check that values are equals.
     *
     * @param message
     * @param expected
     * @param value
     */
    private static void checkEquals(String message, String expected, String value) {
        if (expected.equals(value)) {
            System.out.println("OK - " + message);
        } else {
            System.out.println("Fail - " + message);
        }
    }

}
