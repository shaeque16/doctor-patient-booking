package com.example.RxNow.DoctorPatientBooking.controller;

import com.example.RxNow.DoctorPatientBooking.dto.AppointmentRequestDto;
import com.example.RxNow.DoctorPatientBooking.dto.AppointmentResponseDto;
import com.example.RxNow.DoctorPatientBooking.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public AppointmentResponseDto bookAppointment(@Valid @RequestBody AppointmentRequestDto requestDto){
        return appointmentService.bookAppointment(requestDto);
    }

    @GetMapping(params = "doctorId")
    public List<AppointmentResponseDto> getAppointmentByDoctorId(@RequestParam Long doctorId) {
        return appointmentService.getAllAppointmentByDoctorId(doctorId);
    }

    @GetMapping(params = "patientId")
    public List<AppointmentResponseDto> getAppointmentByPatientId(@RequestParam Long patientId) {
        return appointmentService.getAllAppointmentByPatientId(patientId);
    }


}
