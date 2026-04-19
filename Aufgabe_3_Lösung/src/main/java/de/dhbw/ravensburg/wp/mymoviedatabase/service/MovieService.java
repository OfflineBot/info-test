package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import java.util.List;

public interface MovieService {

    List<String> getCastOfMovie(String movieTitle);
    void changeMovieTitle(long id, String newMovieName);
}
