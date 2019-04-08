package com.fakecinema;

import com.fakecinema.dao.MovieDao;
import com.fakecinema.model.Movie;

import java.sql.SQLException;

/**
 * Created by Vova on 02.04.2019.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Movie movie = new Movie("Шазам!", "2:12", "Кожен з нас в душі супергерой, проте треба трохи магії, щоб розкрити його. Вихованому вулицею 14-річному Біллі Батсону пощастило: він здатен  перетворюватися на дорослого супергероя Шазама. Цим умінням наділив його древній чарівник... Дитина в душі і богоподібний красень ззовні, Шазам насолоджується дорослою версією самого себе і робить те, що робив би з суперможливостями кожен хлопець його віку: просто отримує задоволення! Чи може він літати? Чи є у нього рентгенівський зір? Чи може стріляти блискавками? Чи може пропустити шкільний тест з соціальних досліджень? Шазам з безтурботною дитячою радістю намагається випробувати всі межі своїх здібностей! Але йому доведеться швидко освоїти свої навички, щоб побороти смертоносні сили зла, якими керує доктор Таддеус Сіванна.");
        MovieDao movieDao = new MovieDao();
        movieDao.addMovie(movie);

        for (Movie mv: movieDao.getAllMovies()) {
            System.out.println(mv.getTitle());
            System.out.println(mv.getDuration());
            System.out.println(mv.getDescription());
        }
    }
}
