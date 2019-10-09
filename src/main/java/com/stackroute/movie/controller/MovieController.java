package com.stackroute.movie.controller;


import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exception.MovieAlreadyExistsException;
import com.stackroute.movie.exception.MovieNotFoundException;
import com.stackroute.movie.service.MovieService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping(value = "api/v1")
public class MovieController {
    MovieService movieService;

    @Autowired
    Environment environment;

    @Autowired
    public MovieController(MovieService movieService, Environment environment) {
        this.movieService = movieService;
        this.environment = environment;
    }


    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/saveNewMovie")
    public ResponseEntity<?> saveNewMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
        ResponseEntity responseEntity;
        logger.info("Movie = "+movie);
        logger.debug("Inside saveMovie()");
        movieService.saveNewMovie(movie);
        responseEntity = new ResponseEntity<String>("SuccessFully created",HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<?> getAllMovies() {
        logger.info("All movies = " + movieService.getAllMovie());
        logger.debug("Inside getAllMovies()");
        return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws MovieNotFoundException {
        Optional<Movie> movies;
        logger.info("Id" + id);
        logger.debug("Inside getMovieById()");
        movies = movieService.getById(id);
        return new ResponseEntity<Optional<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@RequestBody Movie movie, @PathVariable int id) throws MovieNotFoundException {
        logger.info("Movie = " + movie + " Id" + id);
        logger.debug("Inside deleteMovie()");
        movieService.deleteById(id);
        return new ResponseEntity<String>("Movie deleted.", HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody Movie movie, @PathVariable int id) throws MovieNotFoundException {
        logger.info("Movie = " + movie + " Id" + id);
        logger.debug("Inside updateMovie()");
        movieService.updateById(movie, id);
        return new ResponseEntity<>(movieService.updateById(movie, id), HttpStatus.OK);
    }

    @GetMapping("/titles/{title}")
    public ResponseEntity<List<Movie>> getByName(@RequestParam String title) {
        List<Movie> movie = movieService.getByName(title);
        return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);
    }

}