package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
       String m = movieRepository.addMovie(movie);
       return m;
    }

    public String addDirector(Director director) {
        String d = movieRepository.addDirector(director);
        return d;
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String dirName) {
        return movieRepository.getMoviesByDirectorName(dirName);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String dirName) {
         movieRepository.deleteDirectorByName(dirName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
