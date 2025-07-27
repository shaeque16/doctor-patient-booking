package com.example.RxNow.DoctorPatientBooking.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String email;
    private String specialization;
    private LocalTime availableFrom;
    private LocalTime availableTo;
}
