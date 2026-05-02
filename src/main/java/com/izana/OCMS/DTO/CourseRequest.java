package com.izana.OCMS.DTO;

import lombok.Data;

@Data
public class CourseRequest {
    private String title;
    private String description;
    private int price;

    private Long instructorId;
}
