package com.example.RxNow.DoctorPatientBooking.repositories;

import com.example.RxNow.DoctorPatientBooking.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
