package com.awl.tdd.test;

import com.awl.tdd.model.HightTechAlarm;

/**
 * @author Olivier PEREZ [a570709]
 */
public class FakeHightTechAlarm extends HightTechAlarm {

    private boolean mailSent;

    protected void sendMail() {
        mailSent = true;
    }

    public boolean isMailSent() {
        return mailSent;
    }
}
