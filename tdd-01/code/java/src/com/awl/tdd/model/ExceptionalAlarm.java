package com.awl.tdd.model;

/**
 * @author Olivier PEREZ [a570709]
 */
public class ExceptionalAlarm extends Alarm {

    public String makeNoise() {
        throw new AlarmException("pouet");
    }

    public class AlarmException extends RuntimeException {
        public AlarmException(String message) {
            super(message);
        }
    }
}
