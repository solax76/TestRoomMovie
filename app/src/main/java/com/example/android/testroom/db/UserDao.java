package com.example.android.testroom.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Di Rienzo on 02/12/17.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM TopRatedMovie")
    List<TopRatedMovie> getTopRatedMovies();

    @Insert
    void insertTopRatedMovie(TopRatedMovie topRatedMovie);

    @Query("SELECT * FROM MostPopularMovie")
    List<MostPopularMovie> getMostPopularMovies();

    @Insert
    void insertMostPopularMovie(MostPopularMovie mostPopularMovie);

    @Query("SELECT * FROM FavoriteMovie")
    List<FavoriteMovie> getFavoriteMovie();

    @Insert
    void insertFavoriteMovie(FavoriteMovie favoriteMovie);

}
