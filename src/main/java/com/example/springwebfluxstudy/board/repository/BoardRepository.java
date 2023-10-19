package com.example.springwebfluxstudy.board.repository;

import com.example.springwebfluxstudy.board.entity.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BoardRepository extends ReactiveMongoRepository<Board, String> {
}
