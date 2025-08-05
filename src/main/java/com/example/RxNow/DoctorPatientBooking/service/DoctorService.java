package com.example.RxNow.DoctorPatientBooking.service;

import com.example.RxNow.DoctorPatientBooking.dto.DoctorResponseDto;
import com.example.RxNow.DoctorPatientBooking.entity.Doctor;
import com.example.RxNow.DoctorPatientBooking.exception.NotFoundException;
import com.example.RxNow.DoctorPatientBooking.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Page<DoctorResponseDto> getAllDoctors(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return doctorRepository.findAll(pageable)
                .map(this::mapToResposneDto);
    }

    public DoctorResponseDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(("Doctor not found")));
        return mapToResposneDto(doctor);
    }

    private DoctorResponseDto mapToResposneDto(Doctor doctor) {

        return DoctorResponseDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .specialization(doctor.getSpecialization())
                .availableFrom(doctor.getAvailableFrom())
                .availableTo(doctor.getAvailableTo())
                .build();
    }



}
