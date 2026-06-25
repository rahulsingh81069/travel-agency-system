package com.cognizant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.UsserCredential;

public interface UserCredentialRepository extends JpaRepository<UsserCredential, Integer> {
  Optional<UsserCredential> findByName(String username);
}
