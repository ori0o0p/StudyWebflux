package com.example.springwebfluxstudy.repository;

import com.example.springwebfluxstudy.entity.Board;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BoardRepository extends ReactiveMongoRepository<Board, String> {
}
