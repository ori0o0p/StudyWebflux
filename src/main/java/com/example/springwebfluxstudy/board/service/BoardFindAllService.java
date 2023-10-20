package com.example.springwebfluxstudy.board.service;

import com.example.springwebfluxstudy.board.dto.response.BoardResponse;
import com.example.springwebfluxstudy.board.repository.BoardRepository;
import com.example.springwebfluxstudy.board.entity.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardFindAllService {
    private final BoardRepository boardRepository;

    public Flux<BoardResponse> execute() {
        Flux<BoardResponse> list = boardRepository.findAll()
                .flatMap(this::createResponse)
                .subscribeOn(Schedulers.boundedElastic());

        log.info(Thread.currentThread().getName());

        return Flux.from(list);
    }

    private Mono<BoardResponse> createResponse(Board board) {
        return Mono.just(BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .build());
    }

}
