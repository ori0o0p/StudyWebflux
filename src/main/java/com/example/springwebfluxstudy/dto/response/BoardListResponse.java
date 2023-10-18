package com.example.springwebfluxstudy.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BoardListResponse {
    private final List<BoardResponse> boardList;

}
