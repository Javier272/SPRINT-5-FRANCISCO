package com.exampleback.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CreateMetricRequestDTO {
    private String developerName;
    private LocalDate metricDate;
    private Integer commits;
    private Integer bugsFixed;
    private Integer tasksCompleted;
    private Integer storyPoints;
}