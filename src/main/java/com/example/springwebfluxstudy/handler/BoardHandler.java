package com.example.springwebfluxstudy.handler;

import com.example.springwebfluxstudy.dto.request.BoardRequest;
import com.example.springwebfluxstudy.dto.response.BoardListResponse;
import com.example.springwebfluxstudy.dto.response.BoardResponse;
import com.example.springwebfluxstudy.service.BoardCreateService;
import com.example.springwebfluxstudy.service.BoardFindAllService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BoardHandler {
    private final BoardCreateService boardCreateService;
    private final BoardFindAllService boardFindAllService;


    public Mono<ServerResponse> createBoard(ServerRequest request) {
        Mono<Void> createRequest = request.bodyToMono(BoardRequest.class)
                .flatMap(boardCreateService::execute);

        return ServerResponse.created(URI.create("/board"))
                .body(createRequest, Void.class);
    }

    public Mono<ServerResponse> boardList() {
        //Mono<BoardListResponse> boardListResponseMono = boardFindAllService.execute();
        Flux<BoardResponse> boardResponseFlux = boardFindAllService.execute();

        return ServerResponse.ok()
                .body(boardResponseFlux, Flux.class); // ??
        //return ServerResponse.ok()
        //        .body(boardListResponseMono, BoardListResponse.class);
    }

}
