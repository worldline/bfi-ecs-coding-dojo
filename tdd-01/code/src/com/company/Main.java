package com.company;

import com.company.model.Car;
import com.company.model.Engine;
import com.company.model.Key;

public class Main {

	public static void main(String[] args) {
		should_start_engine();
		should_start_engine_while_starting_a_car();
        should_not_start_engine_without_key();
        should_not_start_engine_without_matching_key();
        should_start_engine_with_matching_key();
	}

    private static void should_not_start_engine_without_key() {
        // Given
        FakeEngine engine = new FakeEngine();
        Car car = new Car(new Key(),engine);

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
        // GIVEN
        FakeEngine fakeEngine = new FakeEngine();
        Key matchingKey = new Key();
        Car car = new Car(matchingKey, fakeEngine);

        // WHEN
        car.start(matchingKey);

        // THEN
        check(fakeEngine.isStartMethodCalled(), "Should start engine when starting car with the matching key");
        class Toto {
            public Integer a;
            public Double b;
            public Long c;
            public Float d;
        }

        Toto toto = new Toto();
        System.out.println(toto.a);
        System.out.println(toto.b);
        System.out.println(toto.c);
        System.out.println(toto.d);
    }

	private static void should_start_engine() {
		Engine engine = new Engine();

		String sound = engine.start();

		check("vrooom".equals(sound), "Démarrage du moteur");
	}

	private static void should_start_a_car_INTEGRATION() {
		// GIVEN
		Car car = new Car(new Key(), new Engine());
        Key key = new Key();

		// WHEN
		String sound = car.start(key);

		// THEN
		check("vrooom".equals(sound), "Démarrage du moteur lors du démarrage de la voiture");
	}

	private static void should_start_engine_while_starting_a_car() {
		// GIVEN
		FakeEngine engine = new FakeEngine();
        Key key = new Key();
        Car car = new Car(key, engine);

		// WHEN
		car.start(key);

		// THEN
		check(engine.isStartMethodCalled(), "Démarrage du moteur lors du démarrage de la voiture");
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
