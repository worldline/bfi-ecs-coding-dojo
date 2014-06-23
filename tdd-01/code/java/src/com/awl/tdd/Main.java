package com.awl.tdd;

import com.awl.tdd.model.Alarm;
import com.awl.tdd.model.Car;
import com.awl.tdd.model.Engine;
import com.awl.tdd.model.ExceptionalAlarm;
import com.awl.tdd.model.Key;
import com.awl.tdd.test.FakeEngine;
import com.awl.tdd.test.FakeHightTechAlarm;

public class Main {

    public static void main(String[] args) {
        try {
        // Unit
        should_start_engine(); // Step 1

        should_start_engine_when_starting_car(); // Step 1 and 2

        should_not_start_car_without_key(); // Step 2
        should_not_start_car_with_worng_keys(); // Step 2

            should_pouet_alarm(); // Step 3
            should_pouet_when_starting_car_without_key(); // Step 3
            should_hightech_alarm_send_mail(); // Step 3
            should_send_mail_when_using_hightech_alarm(); // Step 3
            should_throw_eception_when_using_exceptionalarm(); // Step 3

        // Integration
        INTEGRATION_should_start_car(); // Step 1
        } catch (Exception e) {
            System.out.println("A test failed: ");
            e.printStackTrace();
    }
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

    private static void should_start_engine_when_starting_car() throws Exception {
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

    private static void should_not_start_car_without_key() throws Exception {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Car car = new Car(fakeEngine, "AZERTYUIOP");

        // When
        String sound = car.start(null);

        // Then
        checkEquals("Car (without alarm) should mute when starting without key", "", sound);
        checkFalse("Starting car should not start engine without key", fakeEngine.isStartCalled());
    }

    private static void should_not_start_car_with_worng_keys() throws Exception {
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

    private static void should_pouet_alarm() {
        // Given
        Alarm alarm = new Alarm();

        // When
        String sound = alarm.makeNoise();

        // Then
        checkEquals("An alarm have to make some noise", "pouet", sound);
    }

    private static void should_pouet_when_starting_car_without_key() throws Exception {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        Alarm alarm = new Alarm();
        Car car = new Car(fakeEngine, "AZERTYUIOP");
        car.setAlarm(alarm);

        // When
        String sound = car.start(null);

        // Then
        checkEquals("The alarm must make some noise when starting without key", "pouet", sound);
        checkFalse("Starting car should not start engine without key", fakeEngine.isStartCalled());
    }

    private static void should_hightech_alarm_send_mail() {
        // Given
        FakeHightTechAlarm alarm = new FakeHightTechAlarm();

        // When
        String sound = alarm.makeNoise();

        // Then
        checkTrue("Hight-tech alarm should send mail", alarm.isMailSent());
        checkEquals("Hight-tech alarm does not make any noise", "", sound);
    }

    private static void should_send_mail_when_using_hightech_alarm() throws Exception {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        FakeHightTechAlarm alarm = new FakeHightTechAlarm();
        Car car = new Car(fakeEngine, "AZERTYUIOP");
        car.setAlarm(alarm);

        // When
        String sound = car.start(null);

        // Then
        checkTrue("Starting car without key should send mail", alarm.isMailSent());
        checkFalse("Starting car without key should not start engine", fakeEngine.isStartCalled());
        checkEquals("The High-Tech alarm must not make some noise when starting without key", "", sound);
    }

    public static void should_throw_eception_when_using_exceptionalarm() {
        // Given
        FakeEngine fakeEngine = new FakeEngine("tagazoo");
        ExceptionalAlarm exceptionalAlarm = new ExceptionalAlarm();
        Car car = new Car(fakeEngine, "AZERTYUIOP");
        car.setAlarm(exceptionalAlarm);

        // When
        try {
            car.start(null);
            fail("ExceptionalAlarm should throw AlarmException");
        } catch (ExceptionalAlarm.AlarmException e) {
            success("ExceptionalAlarm should throw AlarmException");
            checkFalse("Starting car without key should not start engine", fakeEngine.isStartCalled());
        }
    }

    /* Integration tests */

    private static void INTEGRATION_should_start_car() throws Exception {
        // Given
        Car car = new Car(new Engine(), "AZERTYUIOP");
        Key key = new Key("AZERTYUIOP");

        // When
        String sound = car.start(key);

        // Then
        checkEquals("Car and Engine should start", "vrooom", sound);
    }

    /* Testing functions */

    private static void fail(String message) {
        System.err.println("Fail - " + message);
    }

    private static void success(String message) {
        System.out.println("OK - " + message);
    }

    /**
     * Check that condition is respected.
     *
     * @param message   The feature we are testing
     * @param condition The condition to respect
     */
    private static void checkTrue(String message, boolean condition) {
        if (condition) {
            success(message);
        } else {
            fail(message);
        }
    }

    /**
     * Check that condition is NOT respected.
     *
     * @param message   The feature we are testing
     * @param condition The condition not to respect
     */
    private static void checkFalse(String message, boolean condition) {
        checkTrue(message, !condition);
    }

    /**
     * Check that values are equals.
     *
     * @param message  The feature we are testing
     * @param expected The excpected value
     * @param value    The actual value
     */
    private static void checkEquals(String message, String expected, String value) {
        if (expected.equals(value)) {
            success(message);
        } else {
            fail(message);
        }
    }

}
