package com.stackroute.movie.service;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MovieServiceImpl implements MovieService{
    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl( MovieRepository movieRepository){
        this.movieRepository= movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie saveMovie=movieRepository.save(movie);
        return saveMovie;
    }

    @Override
    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie saveMovie=movieRepository.save(movie);
        return saveMovie;
    }
}
