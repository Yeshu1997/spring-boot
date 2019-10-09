package com.stackroute.movie.seedData;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exception.MovieAlreadyExistsException;
import com.stackroute.movie.exception.MovieNotFoundException;
import com.stackroute.movie.service.MovieService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.logging.Logger;

public class CommandLineAppStartRunner implements CommandLineRunner {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CommandLineAppStartRunner.class);
    com.stackroute.movie.service.MovieService movieService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("this is via command line runner");
        Movie movie1 = new Movie(10,"Godfather","2003-12-09","The godfather",2000);
        movieService.saveNewMovie(movie1);
    }

}