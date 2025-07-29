package com.example.RxNow.DoctorPatientBooking.dto;

import java.time.LocalTime;

public class DoctorResponseDto {
    private Long id;
    private String name;
    private String email;
    private String specialization;
    private LocalTime availableFrom;
    private LocalTime availableTo;

    public DoctorResponseDto(Long id, String name, String email, String specialization,
                             LocalTime availableFrom, LocalTime availableTo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalTime availableTo) {
        this.availableTo = availableTo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}

