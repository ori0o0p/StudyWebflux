package com.example.springwebfluxstudy.service;

import com.example.springwebfluxstudy.dto.response.BoardResponse;
import com.example.springwebfluxstudy.entity.Board;
import com.example.springwebfluxstudy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardFindAllService {
    private final BoardRepository boardRepository;

    public Flux<BoardResponse> execute() {
        Flux<BoardResponse> list = boardRepository.findAll().flatMap(this::createResponse);
        return Flux.from(list);
    }

    private Mono<BoardResponse> createResponse(Board board) {
        return Mono.just(
                BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .build());
    }

}
