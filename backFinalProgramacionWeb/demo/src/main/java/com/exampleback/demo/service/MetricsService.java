package com.exampleback.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.exampleback.demo.dto.CreateMetricRequestDTO;
import com.exampleback.demo.dto.MetricResponseDTO;
import com.exampleback.demo.model.DeveloperMetric;
import com.exampleback.demo.repository.DeveloperMetricRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetricsService {

private final DeveloperMetricRepository repository;

public List<MetricResponseDTO> getMetricData(
        String metric) {

List<DeveloperMetric> metrics =
        repository.findAll();

return metrics.stream()
        .map(m -> {

                MetricResponseDTO dto =
                        new MetricResponseDTO();

                dto.setLabel(
                        m.getMetricDate().toString());

                switch (metric) {

                case "commits":
                        dto.setValue(m.getCommits());
                        break;

                case "bugs":
                        dto.setValue(m.getBugsFixed());
                        break;

                case "tasks":
                        dto.setValue(m.getTasksCompleted());
                        break;

                case "storyPoints":
                        dto.setValue(m.getStoryPoints());
                        break;

                default:
                        dto.setValue(0);
                }

                return dto;
        })
        .toList();
        
}
public void createMetric(CreateMetricRequestDTO requestDTO) {
        DeveloperMetric newMetric = new DeveloperMetric();
        
        // Mapea los datos del DTO a la Entidad real
        newMetric.setDeveloperName(requestDTO.getDeveloperName());
        newMetric.setMetricDate(requestDTO.getMetricDate());
        newMetric.setCommits(requestDTO.getCommits());
        newMetric.setBugsFixed(requestDTO.getBugsFixed());
        newMetric.setTasksCompleted(requestDTO.getTasksCompleted());
        newMetric.setStoryPoints(requestDTO.getStoryPoints());

        // Guarda en la db
        repository.save(newMetric);
    }
}