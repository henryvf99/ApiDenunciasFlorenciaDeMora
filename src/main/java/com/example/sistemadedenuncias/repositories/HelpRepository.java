package com.example.sistemadedenuncias.repositories;

import com.example.sistemadedenuncias.models.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<Help, Integer> {
}
