
import dao.impl.MovieDaoImpl;
import model.Movie;
import model.enums.Genre;
import service.impl.MovieServiceImpl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO: 14.09.2023 для началы работы необходимо положить 5 фильмов в JSON файл
        //  (для этого используйте метод writeToFile(String path, Movie movie); из класса MovieDao
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(2, "Interstellar", Genre.Fantasy, LocalDate.of(2014, 10, 26), 715751038));
        movieList.add(new Movie(1, "Forest Gump", Genre.Drama, LocalDate.of(1994, 3, 21), 678226465));
        movieList.add(new Movie(3, "Slumdog Millionaire", Genre.Drama, LocalDate.of(2008, 8, 30), 378000000));
        movieList.add(new Movie(4, "Wolf creek", Genre.Drama, LocalDate.of(1983, 11, 10), 123456789));
//        MovieDaoImpl movieDao = new MovieDaoImpl();
//        movieDao.writeToFile("movie.json", movieList);
//        System.out.println(movieDao.readFromFile("movie.json"));
        MovieServiceImpl movieService = new MovieServiceImpl();
//        System.out.println(movieService.filterByGenre(Genre.Fantasy));
         movieService.updateById(3,new Movie(2,"1+1",Genre.Drama,LocalDate.of(2006,3,23),2303493));



    }
}