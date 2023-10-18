package com.example.springwebfluxstudy.service;

import com.example.springwebfluxstudy.dto.request.BoardRequest;
import com.example.springwebfluxstudy.entity.Board;
import com.example.springwebfluxstudy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardRepository boardRepository;

    public Mono<Void> execute(BoardRequest request) {
        return Mono.just(
                Board.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build())
                .flatMap(boardRepository::save)
                .then();
    }

}
