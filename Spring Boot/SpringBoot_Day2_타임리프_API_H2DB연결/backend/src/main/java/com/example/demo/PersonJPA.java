package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO역할
public interface PersonJPA extends JpaRepository<Person, Integer>{

}
