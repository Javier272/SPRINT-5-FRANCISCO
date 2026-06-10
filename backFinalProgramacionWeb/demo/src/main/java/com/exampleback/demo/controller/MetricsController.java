package com.exampleback.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleback.demo.dto.MetricResponseDTO;
import com.exampleback.demo.dto.CreateMetricRequestDTO;
import com.exampleback.demo.service.MetricsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metrics")
@RequiredArgsConstructor
public class MetricsController {

    private final MetricsService service;

    @GetMapping("/{metric}")
    public List<MetricResponseDTO> getMetricData(
            @PathVariable String metric) {
        return service.getMetricData(metric);
    }

    // NUEVO ENDPOINT PARA LA PROPUESTA DE MEJORA
    @PostMapping
    public ResponseEntity<String> createMetric(@RequestBody CreateMetricRequestDTO requestDTO) {
        service.createMetric(requestDTO);
        return new ResponseEntity<>("Métrica guardada exitosamente en la base de datos", HttpStatus.CREATED);
    }
}