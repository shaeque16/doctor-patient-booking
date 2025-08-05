package com.example.RxNow.DoctorPatientBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email must be valid")
    private String email;
    private String phone;
    private String specialization;

    @NotNull(message = "Available from time is required")
    private LocalTime availableFrom;

    @NotNull(message = "Available to time is required")
    private LocalTime availableTo;

}
