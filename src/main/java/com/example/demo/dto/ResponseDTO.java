package com.example.demo.dto;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseDTO<T> {
    private String error;
    private List<T> data;

}
