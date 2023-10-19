package com.example.springwebfluxstudy.board.router;

import com.example.springwebfluxstudy.board.handler.BoardHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RequiredArgsConstructor
public class BoardRouter {

    private final BoardHandler boardHandler;

    @Bean
    public RouterFunction<ServerResponse> boardRoute() {
        return route().path("/board", builder ->
                builder.nest(accept(MediaType.APPLICATION_JSON), routes -> routes
                        .POST("", boardHandler::createBoard))
                        .GET("/list", request -> boardHandler.boardList())
        ).build();
    }

}
