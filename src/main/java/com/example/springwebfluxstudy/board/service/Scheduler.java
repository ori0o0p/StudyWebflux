package com.example.springwebfluxstudy.board.service;

import com.example.springwebfluxstudy.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {
    private final BoardRepository boardRepository;

    @Scheduled(cron = "* */10 * * * *")
    public void run() {
        boardRepository.deleteAll().subscribe();
    }

}
