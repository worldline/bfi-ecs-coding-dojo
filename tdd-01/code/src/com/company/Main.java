package com.company;

import com.company.model.Car;
import com.company.model.Engine;
import com.company.model.Key;

public class Main {

    public static void main(String[] args) {
        // Step 1
        should_start_engine();
        should_start_a_car_INTEGRATION();
        should_start_engine_while_starting_a_car();

        // Step 2
        should_start_engine_with_matching_key();
        should_not_start_engine_without_key();
        should_not_start_engine_without_matching_key();
    }

    private static void should_not_start_engine_without_key() {
        // Given
        FakeEngine engine = new FakeEngine();
        Car car = new Car(new Key(), engine);

        // When
        car.start(null);

        // Then
        check(!engine.isStartMethodCalled(), "Doesn't expect the engine to be started without any key");
    }

    private static void should_not_start_engine_without_matching_key() {
        // Given
        FakeEngine engine = new FakeEngine();
        Key wrongKey = new Key();
        Key matchingKey = new Key();
        Car car = new Car(matchingKey, engine);

        // When
        car.start(wrongKey);

        // Then
        check(!engine.isStartMethodCalled(), "Doesn't expect the engine to be started without matching key");
    }

    private static void should_start_engine_with_matching_key() {
        // Given
        FakeEngine fakeEngine = new FakeEngine();
        Key matchingKey = new Key();
        Car car = new Car(matchingKey, fakeEngine);

        // When
        car.start(matchingKey);

        // Then
        check(fakeEngine.isStartMethodCalled(), "Should start engine when starting car with the matching key");
    }

    private static void should_start_engine() {
        // Given
        Engine engine = new Engine();

        // When
        String sound = engine.start();

        // Then
        check("vrooom".equals(sound), "Engine should start");
    }

    private static void should_start_a_car_INTEGRATION() {
        // Given
        Key key = new Key();
        Car car = new Car(key, new Engine());

        // When
        String sound = car.start(key);

        // Then
        check("vrooom".equals(sound), "Engine should say vrooom when car starts");
    }

    private static void should_start_engine_while_starting_a_car() {
        // Given
        FakeEngine engine = new FakeEngine();
        Key key = new Key();
        Car car = new Car(key, engine);

        // When
        car.start(key);

        // Then
        check(engine.isStartMethodCalled(), "When car is starting, it should start engine too");
    }

    private static void check(final boolean equation, final String message) {
        if (equation) {
            System.out.println("OK - " + message);
        } else {
            System.out.println("FAIL - " + message);
        }
    }

    private static class FakeEngine extends Engine {

        private boolean started;

        public boolean isStartMethodCalled() {
            return started;
        }

        public String start() {
            started = true;
            return null;
        }

    }
}
