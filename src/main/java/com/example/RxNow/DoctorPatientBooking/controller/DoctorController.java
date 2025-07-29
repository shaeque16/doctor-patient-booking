package com.example.RxNow.DoctorPatientBooking.controller;

import com.example.RxNow.DoctorPatientBooking.dto.DoctorResponseDto;
import com.example.RxNow.DoctorPatientBooking.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public Page<DoctorResponseDto> getAllDoctors(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        return doctorService.getAllDoctors(page,size);
    }

    @GetMapping("/{id}")
    public DoctorResponseDto getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}
