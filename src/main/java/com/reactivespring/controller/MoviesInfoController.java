package com.reactivespring.controller;

import com.reactivespring.domain.MovieInfo;
import com.reactivespring.service.MoviesInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.*;

@RestController
@RequestMapping("/v1")
public class MoviesInfoController {

    private MoviesInfoService movieInfoService;

    public MoviesInfoController(MoviesInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @PostMapping("/movieinfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MovieInfo> addMovieInfo(@RequestBody MovieInfo movieInfo) {
        return movieInfoService.addMovieInfo(movieInfo);
    }

    @GetMapping("/movieinfos")
    public Flux<MovieInfo> getAllMovieInfos() {

        return movieInfoService.getAllMovieInfos();
    }

    @GetMapping("/movieinfos/{id}")
    public Mono<MovieInfo> getAllMovieInfoById(@PathVariable String id) {

        return movieInfoService.getMovieInfoById(id);
    }

    @PutMapping("/movieinfos/{id}")
    public Mono<MovieInfo> addMovieInfo(@RequestBody MovieInfo movieInfo, @PathVariable String id) {
        return movieInfoService.updateMovieInfo(movieInfo, id);
    }

    @DeleteMapping("/movieinfos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMovieInfo(@PathVariable String id) {
        return movieInfoService.deleteMovieInfo(id);
    }
}

