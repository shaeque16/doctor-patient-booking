package com.example.RxNow.DoctorPatientBooking.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequestDto {

    private Long doctorId;
    private Long patientId;
    private LocalDate appointmnetDate;
    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;

}
