package com.marketing1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing1.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
