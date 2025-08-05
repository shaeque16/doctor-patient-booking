package com.example.RxNow.DoctorPatientBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "patients")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private Integer age;

    @Email(message = "Email must be valid")
    private String email;
    private String phone;
    private String gender;

}


