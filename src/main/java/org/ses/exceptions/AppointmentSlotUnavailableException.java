package org.ses.exceptions;

public class AppointmentSlotUnavailableException extends RuntimeException {
    public AppointmentSlotUnavailableException(String message) {
        super(message);
    }
}
