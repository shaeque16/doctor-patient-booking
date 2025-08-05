package com.example.RxNow.DoctorPatientBooking.entity;

import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Doctor is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @NotNull(message = "Patient is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull(message = "Appointment date is required")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment start time is required")
    private LocalTime appointmentStartTime;

    @NotNull(message = "Appointment end time is required")
    private LocalTime appointmentEndTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

}
