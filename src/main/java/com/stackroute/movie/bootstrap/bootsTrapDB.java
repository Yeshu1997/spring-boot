package com.stackroute.movie.bootstrap;

import com.stackroute.movie.domain.Movie;
import com.stackroute.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class bootsTrapDB implements ApplicationListener<ContextRefreshedEvent> {

    private MovieRepository movieRepository;

    @Autowired
    public bootsTrapDB(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //com.stackroute.movie.domain.Movie.setTitle("Alice").srelease_date("2018-20-09").id(20).overview("thriller").build();
        Movie movie1 = new Movie();
        movie1.setId(10);
        movie1.setTitle("The Machinist");
        movie1.setOverview("Tgdd dhd ");
        movie1.setRelease_date("2006-12-09");
        movie1.setRevenue(1000);

        movieRepository.save(movie1);
    }
}