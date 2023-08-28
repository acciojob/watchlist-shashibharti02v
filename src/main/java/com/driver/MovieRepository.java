package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {


    private HashMap<String, Movie> movieDB;
    private HashMap<String, Director>dirDB ;
    private HashMap<String, List<String>>directorOrMovie;

    public MovieRepository() {
        this.movieDB = new HashMap<String, Movie>();
        this.dirDB = new HashMap<String, Director>();
        this.directorOrMovie = new HashMap<String, List<String>>();
    }

    public String addMovie(Movie movie) {
     if(movieDB.containsKey(movie.getName())){
         return "Movie already added";
     }
     movieDB.put(movie.getName(), movie);
     return "Movie added successfully";
    }

    public String addDirector(Director director) {
        if(dirDB.containsKey(director.getName())){
            return "Director already added";
        }
        dirDB.put(director.getName(), director);
        return "Director added successfully";
    }

    public void addMovieDirectorPair(String movie, String director) {
        if (movieDB.containsKey(movie) && dirDB.containsKey(director)) {
            List<String> currMovie = new ArrayList<String>();
            if(directorOrMovie.containsKey(director))currMovie = directorOrMovie.get(director);
                    currMovie.add(movie);
                    directorOrMovie.put(director, currMovie);
        }
    }

    public Movie getMovieByName(String name) {

           return  movieDB.get(name);
    }

    public Director getDirectorByName(String name) {
        return dirDB.get(name);
    }

    public List<String> getMoviesByDirectorName(String dirName) {
        if(directorOrMovie.containsKey(dirName)) {
            List<String> moviesName = new ArrayList<>();
            moviesName = directorOrMovie.get(dirName);
            return moviesName;
        }
        return null;
    }

    public List<String> findAllMovies() {
        List<String> movies = new ArrayList<>();
        for(String s: movieDB.keySet()){
            movies.add(s);
        }
        return movies;
    }

    public void deleteDirectorByName(String dirName) {
       List<String>movies = new ArrayList<>();
       if(directorOrMovie.containsKey(dirName)){
           movies = directorOrMovie.get(dirName);
           for(String movie: movies){

               if(movieDB.containsKey(movie))
                   movieDB.remove(movie);
           }
       }
       directorOrMovie.remove(dirName);
       if(dirDB.containsKey(dirName))
           dirDB.remove(dirName);

    }

    public void deleteAllDirectors() {
      HashSet<String> movieSet = new HashSet<>();

      for(String director: directorOrMovie.keySet()){
          for(String movies: directorOrMovie.get(director))
              movieSet.add(movies);
      }
      for(String movie: movieSet){
          if(movieDB.containsKey(movie))
              movieDB.remove(movie);
      }
    }
}
