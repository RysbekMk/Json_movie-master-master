package service.impl;

import dao.MovieDao;
import dao.impl.MovieDaoImpl;
import model.Movie;
import model.enums.Genre;
import service.MovieService;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;


public class MovieServiceImpl implements MovieService {
    private static final String PATH = "movie.json";
    private final MovieDao movieDao = new MovieDaoImpl();

    @Override
    // TODO: 14.09.2023 вернуть фильм по ID
    public Movie findById(int movieId) throws FileNotFoundException {
        Movie movie = new Movie();
        try {
            movie = movieDao.readFromFile(PATH).stream().filter(movie1 -> movie1.getId() == movieId)
                    .findFirst().orElseThrow(()-> new RuntimeException("File not found !"));
        } catch (NoSuchElementException s) {
            System.out.println(s.getMessage());
        }
        return movie;
    }

    @Override
    // TODO: 14.09.2023 вернуть фильм по названию
    public Movie findByName(String name) {
        Movie movie = new Movie();
        try {
            movie = movieDao.readFromFile(PATH).stream().filter(movie1 -> movie1.getName()
                    .equalsIgnoreCase(name)).findFirst().orElseThrow();
        } catch (RuntimeException | FileNotFoundException s) {
            s.printStackTrace();
        }
        return movie;
    }

    @Override
    // TODO: 14.09.2023 вернуть отсортированный лист по дате создание
    public List<Movie> sortByDate() {
        List<Movie> movies = new ArrayList<>();
        try {
            movies.addAll(movieDao.readFromFile(PATH));
            movies.sort(Comparator.comparing(Movie::getDate));
        } catch (RuntimeException | FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return movies;
    }

    @Override
    // TODO: 14.09.2023 отфилтрововать все фильмы по жанру
    public List<Movie> filterByGenre(Genre genre) {
        List<Movie> movieList = new ArrayList<>();
        try {
            movieList.addAll(movieDao.readFromFile(PATH).stream().filter(movie -> movie.getGenre().equals(genre)).toList());
        } catch (RuntimeException | FileNotFoundException f) {
            f.printStackTrace();
        }
        return movieList;
    }

    @Override
    // TODO: 14.09.2023 найти обьект по ID и изменить его состояние
    public void updateById(int movieId, Movie movie) {
        try { List<Movie> movieList = new ArrayList<>(movieDao.readFromFile(PATH).stream().toList());
            for (int i = 0; i < movieList.size(); i++) {
                if (movieList.get(i).getId() == movieId){
                    movieList.get(i).setId(movieId);
                    movieList.get(i).setName(movie.getName());
                    movieList.get(i).setGenre(movie.getGenre());
                    movieList.get(i).setDate(movie.getDate());
                }
            }
            movieList.forEach(System.out::println);
            movieDao.writeToFile(PATH,movieList);
        } catch (RuntimeException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
