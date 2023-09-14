package com.example.springwebfluxstudy.controller.dto;

import com.example.springwebfluxstudy.controller.dto.request.BoardRequest;
import com.example.springwebfluxstudy.entity.Board;
import com.example.springwebfluxstudy.service.BoardCreateService;
import com.example.springwebfluxstudy.service.BoardFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardCreateService boardCreateService;
    private final BoardFindAllService boardFindAllService;

    @PostMapping
    public Mono<Board> create(@RequestBody BoardRequest request) {
        return boardCreateService.execute(request);
    }

    @GetMapping
    public Flux<Board> findAll() {
        return boardFindAllService.execute();
    }

}


