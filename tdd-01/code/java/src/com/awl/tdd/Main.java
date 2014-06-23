package com.awl.tdd;

import com.awl.tdd.model.Car;
import com.awl.tdd.model.Engine;
import com.awl.tdd.test.FakeEngine;

public class Main {

    public static void main(String[] args) {
        // Unit
        should_start_engine();
        should_start_engine_when_starting_car();

        // Integration
        INTEGRATION_should_start_car();
    }

    private static void should_start_engine_when_starting_car() {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Car car = new Car(fakeEngine);

        // When
        String sound = car.start();

        // Then
        checkTrue("Starting car should start engine",
                fakeEngine.isStartCalled());
        checkEquals("Car should do the same song as engine", "tagazoo", sound);
    }

    private static void INTEGRATION_should_start_car() {
        // Given
        Car car = new Car(new Engine());

        // When
        String sound = car.start();

        // Then
        checkEquals("Car should start", "vrooom", sound);
    }

    private static void should_start_engine() {
        // Given
        Engine engine = new Engine();

        // When
        String sound = engine.start();

        // Then
        checkEquals("Engine should start", "vrooom", sound);
    }

    /**
     * Check if condition is respected.
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
     * Check if values are equals.
     *
     * @param message
     * @param expected
     * @param value
     */
    private static void checkEquals(String message, String expected,
                                    String value) {
        if (expected.equals(value)) {
            System.out.println("OK - " + message);
        } else {
            System.out.println("Fail - " + message);
        }
    }

}
