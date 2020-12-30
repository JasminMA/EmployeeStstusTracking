package com.emp.exceptions;

/**
 * EmployeeTrackingException is used to wrap al the exceptions related to creating & updating Employee
 @author TJanssen
 */
public class EmployeeTrackingException extends Exception {
    public EmployeeTrackingException(String message) {
        super(message);
    }

    public EmployeeTrackingException(String message, Throwable cause) {
        super(message, cause);
    }
}
