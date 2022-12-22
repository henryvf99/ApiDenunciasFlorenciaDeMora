package com.example.sistemadedenuncias.repositories;

import com.example.sistemadedenuncias.models.EmergencyPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyPhoneRepository extends JpaRepository<EmergencyPhone, Integer> {
}
