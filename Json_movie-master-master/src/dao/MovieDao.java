package dao;

import model.Movie;

import java.io.FileNotFoundException;
import java.util.List;

public interface MovieDao {
    void writeToFile(String path, List<Movie> movies);

    List<Movie> readFromFile(String path) throws FileNotFoundException;
}
