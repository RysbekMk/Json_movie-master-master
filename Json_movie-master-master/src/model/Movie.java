package model;

// TODO: 13.09.2023 у вас есть класс Movie у него должен быть следующие поля
//  id,name,genre(enum),createDate(LocalDate),касса

import model.enums.Genre;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

public class Movie {
    private int  id;
    private String name;
    private Genre genre;
    private  LocalDate date ;
    private int cash;

    public Movie(int id, String name, Genre genre, LocalDate date, int cash) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.cash = cash;
    }

    public Movie() {
    }

    public int  getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && cash == movie.cash && Objects.equals(name, movie.name) && genre == movie.genre && Objects.equals(date, movie.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, date, cash);
    }

    @Override
    public String toString() {
        return "\nMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", date=" + date +
                ", cash=" + cash +
                '\n';
    }
}
