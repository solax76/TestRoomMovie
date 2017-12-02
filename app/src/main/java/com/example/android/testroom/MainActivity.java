package com.example.android.testroom;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.testroom.db.AppDatabase;
import com.example.android.testroom.db.FavoriteMovie;
import com.example.android.testroom.db.MostPopularMovie;
import com.example.android.testroom.db.Movie;
import com.example.android.testroom.db.TopRatedMovie;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTitle;
    private EditText mEditAuthor;
    private EditText mEditDescription;
    private TextView mMovieList;

    private AppDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Retrive DB instance
         */
        mDB = AppDatabase.getInstance(this);

        /**
         * Retrive UI controls
         */
        mEditTitle = (EditText)findViewById(R.id.ed_movie_title);
        mEditAuthor= (EditText)findViewById(R.id.ed_movie_author);
        mEditDescription = (EditText)findViewById(R.id.ed_movie_desc);
        mMovieList = (TextView)findViewById(R.id.tv_movie_list);

        /**
         * assign button function for Top Rated Movie
         */
        Button addTopRatedMovie = (Button)findViewById(R.id.btn_add_top_movie);

        addTopRatedMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TopRatedMovie movie = new TopRatedMovie();
                movie.setTitle(mEditTitle.getText().toString());
                movie.setAuthor(mEditAuthor.getText().toString());
                movie.setDescription(mEditDescription.getText().toString());

                mDB.userDao().insertTopRatedMovie(movie);
                mMovieList.setText("Top Rated Movies\n\n");
                for (Movie m : mDB.userDao().getTopRatedMovies()) {
                    mMovieList.append(m.toString() + "\n\n\n");
                }
            }
        });
        /**
         * assign button function for Favorite Movie
         */
        Button addFavoriteMovie = (Button)findViewById(R.id.btn_add_fav_movie);

        addFavoriteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteMovie movie = new FavoriteMovie();
                movie.setAuthor(mEditAuthor.getText().toString());
                movie.setDescription(mEditDescription.getText().toString());

                mDB.userDao().insertFavoriteMovie(movie);
                mMovieList.setText("Favorite Movies\n\n");
                for (Movie m : mDB.userDao().getFavoriteMovie()) {
                    mMovieList.append(m.toString() + "\n\n\n");
                }
            }
        });
        /**
         * assign button function for Popular Movie
         */
        Button addPopularMovie = (Button)findViewById(R.id.btn_add_pop_movie);

        addPopularMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MostPopularMovie movie = new MostPopularMovie();
                movie.setTitle(mEditTitle.getText().toString());
                movie.setAuthor(mEditAuthor.getText().toString());
                movie.setDescription(mEditDescription.getText().toString());

                mDB.userDao().insertMostPopularMovie(movie);
                mMovieList.setText("Most Popular Movies\n\n");
                for (Movie m : mDB.userDao().getMostPopularMovies()) {
                    mMovieList.append(m.toString() + "\n\n\n");
                }

            }
        });

    }



}
