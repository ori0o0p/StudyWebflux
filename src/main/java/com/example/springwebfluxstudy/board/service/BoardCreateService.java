package com.example.springwebfluxstudy.board.service;

import com.example.springwebfluxstudy.board.dto.request.BoardRequest;
import com.example.springwebfluxstudy.board.repository.BoardRepository;
import com.example.springwebfluxstudy.board.entity.Board;
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
