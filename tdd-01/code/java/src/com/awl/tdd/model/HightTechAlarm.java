package com.awl.tdd.model;

/**
 * @author Olivier PEREZ [a570709]
 */
public class HightTechAlarm extends Alarm {
    @Override
    public String makeNoise() {
        sendMail();
        return "";
    }

    protected void sendMail() {
    }
}
