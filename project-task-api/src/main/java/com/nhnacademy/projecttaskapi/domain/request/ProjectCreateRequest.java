package com.nhnacademy.projecttaskapi.domain.request;

import lombok.Data;

@Data
public class ProjectCreateRequest {
    private final String adminId;
    private final String name;
}