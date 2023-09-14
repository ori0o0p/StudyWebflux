package com.example.springwebfluxstudy.service;

import com.example.springwebfluxstudy.entity.Board;
import com.example.springwebfluxstudy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class BoardFindAllService {
    private final BoardRepository boardRepository;

    public Flux<Board> execute() {
        return boardRepository.findAll();
    }

}
