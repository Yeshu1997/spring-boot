package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    public Movie saveNewMovie(Movie movie) ;

    public List<Movie> getAllMovie();

    public Optional<Movie> getById(int id) ;

    public boolean deleteById(int id) ;

    public Movie updateById(Movie movie, int id) ;

}
