package com.example.RxNow.DoctorPatientBooking.controller;

import com.example.RxNow.DoctorPatientBooking.dto.DoctorResponseDto;
import com.example.RxNow.DoctorPatientBooking.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorResponseDto> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorResponseDto getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}
