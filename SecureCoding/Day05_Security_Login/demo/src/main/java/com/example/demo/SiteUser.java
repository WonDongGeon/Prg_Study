package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity //만약에 객체명과 DB명이 일치하지 않을 경우 @Table(name="db테이블명")
@Table(name="siteuser") 

public class SiteUser {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
int id;

@Column
String email;

@Column
String password;
}

