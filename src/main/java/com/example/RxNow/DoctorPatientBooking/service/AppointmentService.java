package com.example.RxNow.DoctorPatientBooking.service;

import com.example.RxNow.DoctorPatientBooking.dto.AppointmentRequestDto;
import com.example.RxNow.DoctorPatientBooking.dto.AppointmentResponseDto;
import com.example.RxNow.DoctorPatientBooking.entity.Appointment;
import com.example.RxNow.DoctorPatientBooking.entity.Doctor;
import com.example.RxNow.DoctorPatientBooking.entity.Patient;
import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import com.example.RxNow.DoctorPatientBooking.exception.AppointmentConflictException;
import com.example.RxNow.DoctorPatientBooking.exception.NotFoundException;
import com.example.RxNow.DoctorPatientBooking.repositories.AppointmentRepository;
import com.example.RxNow.DoctorPatientBooking.repositories.DoctorRepository;
import com.example.RxNow.DoctorPatientBooking.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AppointmentResponseDto bookAppointment(AppointmentRequestDto requestDto) {

        Doctor doctor = doctorRepository.findById(requestDto.getDoctorId())
                .orElseThrow(() ->new NotFoundException("Doctor Not Found"));

        Patient patient = patientRepository.findById(requestDto.getPatientId())
                .orElseThrow(() -> new NotFoundException("Patient not found"));

        checkAvailability(doctor, requestDto.getAppointmentDate(),requestDto.getAppointmentStartTime(), requestDto.getAppointmentEndTime());

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(requestDto.getAppointmentDate());
        appointment.setAppointmentStartTime(requestDto.getAppointmentStartTime());
        appointment.setAppointmentEndTime(requestDto.getAppointmentEndTime());
        appointment.setStatus(AppointmentStatus.CONFIRMED);

        Appointment bookedAppointment = appointmentRepository.save(appointment);

        return mapToResposneDto(bookedAppointment);
    }

    private void checkAvailability(Doctor doctor, LocalDate appointmentDate, LocalTime startTime, LocalTime endTime) {

        if(startTime.isBefore(doctor.getAvailableFrom()) || endTime.isAfter(doctor.getAvailableTo())){
            throw new AppointmentConflictException("Requested time slot is outside of doctor availability");
        }

        List<Appointment> existingAppointment = appointmentRepository.findByDoctorAndAppointmentDate(doctor,appointmentDate);

        for (Appointment appointment : existingAppointment) {
            boolean overlapTiming = !(endTime.isBefore(appointment.getAppointmentStartTime()) || startTime.isAfter(appointment.getAppointmentEndTime()));
            if(overlapTiming){
                throw new AppointmentConflictException("Doctor is already appointed with other patient at this time period");
            }
        }
    }

    public List<AppointmentResponseDto> getAllAppointmentByDoctorId(Long id){
        return appointmentRepository.findByDoctorId(id)
                .stream()
                .map(this::mapToResposneDto)
                .collect(Collectors.toList());
    }

    public List<AppointmentResponseDto> getAllAppointmentByPatientId(Long id){
        return appointmentRepository.findByPatientId(id)
                .stream()
                .map(this::mapToResposneDto)
                .collect(Collectors.toList());
    }

    private AppointmentResponseDto mapToResposneDto(Appointment appointment) {
        return  AppointmentResponseDto.builder()
                .id(appointment.getId())
                .doctorId(appointment.getDoctor().getId())
                .doctorName(appointment.getDoctor().getName())
                .specialization(appointment.getDoctor().getSpecialization())
                .patientId(appointment.getPatient().getId())
                .patientName(appointment.getPatient().getName())
                .patientPhone(appointment.getPatient().getPhone())
                .patientEmail(appointment.getPatient().getEmail())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentStartTime(appointment.getAppointmentStartTime())
                .appointmentEndTime(appointment.getAppointmentEndTime())
                .status(appointment.getStatus())
                .build();

    }

}
