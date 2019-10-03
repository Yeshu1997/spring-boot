package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;


import java.util.List;
public interface MovieService {
    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie updateMovie(Movie movie);
}
