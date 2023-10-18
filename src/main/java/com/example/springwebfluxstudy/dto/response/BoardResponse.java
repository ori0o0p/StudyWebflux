package com.example.springwebfluxstudy.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BoardResponse {

    private String id;
    private String title;
    private String content;

}
