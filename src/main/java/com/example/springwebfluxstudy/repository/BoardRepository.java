package com.example.springwebfluxstudy.repository;

import com.example.springwebfluxstudy.entity.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BoardRepository extends ReactiveMongoRepository<Board, String> {
}
