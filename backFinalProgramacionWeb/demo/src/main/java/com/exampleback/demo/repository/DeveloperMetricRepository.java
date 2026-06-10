package com.exampleback.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exampleback.demo.model.DeveloperMetric;

@Repository
public interface DeveloperMetricRepository extends JpaRepository<DeveloperMetric, Long> {

}