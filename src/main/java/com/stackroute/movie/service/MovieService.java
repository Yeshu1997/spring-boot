
package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.exception.MovieAlreadyExistsException;
import com.stackroute.movie.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    public Movie saveNewMovie(Movie movie) throws MovieAlreadyExistsException;

    public List<Movie> getAllMovie();

    public Optional<Movie> getById(int id) throws MovieNotFoundException ;

    public boolean deleteById(int id) throws MovieNotFoundException;

    public Movie updateById(Movie movie, int id) throws MovieNotFoundException ;

    public List<Movie> getByName(String title);

}