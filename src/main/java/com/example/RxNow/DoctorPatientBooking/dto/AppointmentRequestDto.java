package com.example.RxNow.DoctorPatientBooking.dto;

import com.example.RxNow.DoctorPatientBooking.entity.enums.AppointmentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequestDto {

    @NotNull(message = "Doctor id is required")
    private Long doctorId;

    @NotNull(message = "Patient id is required")
    private Long patientId;

    @NotNull(message = "Appointment date is required")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment start time is required")
    private LocalTime appointmentStartTime;

    @NotNull(message = "Appointment end time is required")
    private LocalTime appointmentEndTime;
    private AppointmentStatus status;


    public AppointmentRequestDto(Long doctorId, Long patientId, LocalDate appointmentDate, LocalTime appointmentStartTime, LocalTime appointmentEndTime, AppointmentStatus status) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.status = status;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }
}
