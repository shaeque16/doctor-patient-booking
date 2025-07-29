package com.example.RxNow.DoctorPatientBooking.exception;

public class AppointmentConflictException extends RuntimeException{
    public AppointmentConflictException(String message){
        super(message);
    }
}
