package com.example.springwebfluxstudy;

import reactor.core.publisher.Flux;

public class FluxSt {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("문자");
        flux.map(i -> "추가 문자" + i);
        flux.subscribe();
    }

}
