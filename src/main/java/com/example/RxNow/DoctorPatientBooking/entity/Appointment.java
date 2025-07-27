package com.example.RxNow.DoctorPatientBooking.entity;

import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDate appointmnetDate;

    private LocalTime appointmentStartTime;

    private LocalTime appointmentEndTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

}
