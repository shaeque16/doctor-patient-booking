package com.example.RxNow.DoctorPatientBooking.dto;

import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@AllArgsConstructor
public class AppointmentResponseDto {
    private Long id;
    private Long doctorId;
    private String doctorName;
    private String specialization;

    private Long patientId;
    private String patientName;
    private String patientPhone;
    private String patientEmail;

    private LocalDate appointmentDate;
    private LocalTime appointmentStartTime;
    private LocalTime appointmentEndTime;

    private AppointmentStatus status;

}
