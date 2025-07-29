package com.example.RxNow.DoctorPatientBooking.service;

import com.example.RxNow.DoctorPatientBooking.dto.DoctorResponseDto;
import com.example.RxNow.DoctorPatientBooking.entity.Doctor;
import com.example.RxNow.DoctorPatientBooking.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<DoctorResponseDto> getAllDoctors(){
        return doctorRepository.findAll().stream()
                .map(this::mapToResposneDto)
                .collect(Collectors.toList());
    }

    public DoctorResponseDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Doctor not found")));
        return mapToResposneDto(doctor);
    }


    private DoctorResponseDto mapToResposneDto(Doctor doctor) {
        return new DoctorResponseDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getSpecialization(),
                doctor.getAvailableFrom(),
                doctor.getAvailableTo()
        );
    }



}
