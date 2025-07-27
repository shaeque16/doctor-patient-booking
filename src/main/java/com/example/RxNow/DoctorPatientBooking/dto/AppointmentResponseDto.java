package com.example.RxNow.DoctorPatientBooking.dto;

import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentResponseDto {
    private Long Id;
    private Long doctorId;
    private Long doctorName;
    private Long specialization;

    private Long patientId;
    private String patientName;
    private String patientPhone;
    private String patientEmail;

    private LocalDate appointmnetDate;
    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;

    private AppointmentStatus status;
}
