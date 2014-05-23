package com.company;

import com.company.model.Car;
import com.company.model.Engine;

public class Main {

	public static void main(String[] args) {
		should_start_engine();
		should_start_engine_while_starting_a_car();
	}

	private static void should_start_engine() {
		Engine engine = new Engine();

		String sound = engine.start();

		check("vrooom".equals(sound), "Démarrage du moteur");
	}

	private static void should_start_a_car_INTEGRATION() {
		// GIVEN
		Car car = new Car(new Engine());

		// WHEN
		String sound = car.start();

		// THEN
		check("vrooom".equals(sound), "Démarrage du moteur lors du démarrage de la voiture");
	}

	private static void should_start_engine_while_starting_a_car() {
		// GIVEN
		FakeEngine engine = new FakeEngine();
		Car car = new Car(engine);

		// WHEN
		car.start();

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
