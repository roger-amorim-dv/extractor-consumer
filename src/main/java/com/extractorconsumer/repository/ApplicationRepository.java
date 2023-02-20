package com.extractorconsumer.repository;

import com.extractorconsumer.domain.ApplicationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDomain, Long> {}
