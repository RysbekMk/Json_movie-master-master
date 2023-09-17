package service;

import model.Movie;
import model.enums.Genre;

import java.io.FileNotFoundException;
import java.util.List;

public interface MovieService {
    Movie findById(int movieId) throws FileNotFoundException;

    Movie findByName(String name);

    List<Movie> sortByDate();

    List<Movie> filterByGenre(Genre genre);

    void updateById(int movieId, Movie movie);
}
