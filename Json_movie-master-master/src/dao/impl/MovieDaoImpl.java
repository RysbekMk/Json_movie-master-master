package dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.MovieDao;
import model.Movie;
import model.enums.Genre;
import service.LocalDateTypeAdapter;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class MovieDaoImpl implements MovieDao {
    // TODO: 14.09.2023 положить фильм в указанной JSON файл
    @Override
    public void writeToFile(String path, List<Movie> movies) {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
            String jsonString = gson.toJson(movies);
            try (FileWriter fileWriter = new FileWriter(path)) {
                fileWriter.write(jsonString);
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully!!!");
    }

    // TODO: 14.09.2023 вернуть список фильмов из JSON файла (путь указан в параметре метода)
    @Override
    public List<Movie> readFromFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Movie> movieList = new ArrayList<>();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        try {
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            fileReader.close();
            Movie[] movie = gson.fromJson(String.valueOf(stringBuilder), Movie[].class);
            movieList.addAll(List.of(movie));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;
    }
}