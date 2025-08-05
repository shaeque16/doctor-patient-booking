package com.example.RxNow.DoctorPatientBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Builder
@Data
@AllArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private String name;
    private String email;
    private String specialization;
    private LocalTime availableFrom;
    private LocalTime availableTo;

}

