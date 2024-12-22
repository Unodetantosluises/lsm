package com.languajesignalgroup.lsm_web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CourseDto {
    private Long courseId;

    private String courseName;

    private String courseCover;

    private Long teacherId; //Evita traer la entidad Teacher completa

    private  String teacherName;

    private Long categoryId; //Evita traer la entidad Category completa

    private String categoryName;

    private LocalDateTime creationDate;

    private List<Long> lessons; //Referencias a los IDs de las lecciones

    private int totalEnrollments; //Numero de inscripciones, evita cargar toda la lista
}
