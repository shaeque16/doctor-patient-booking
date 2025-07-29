package com.example.RxNow.DoctorPatientBooking.repositories;

import com.example.RxNow.DoctorPatientBooking.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
