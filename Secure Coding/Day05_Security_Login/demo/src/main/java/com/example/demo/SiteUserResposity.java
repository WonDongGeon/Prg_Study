package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SiteUserResposity extends JpaRepository<SiteUser, Integer>{

	Optional<SiteUser> findByEmail(String email);
}
