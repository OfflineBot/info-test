package de.dhbw.ravensburg.wp.mymoviedatabase.repository;

import de.dhbw.ravensburg.wp.mymoviedatabase.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String substring);
    List<Movie> findByImdbRatingGreaterThan(double rating);
    List<Movie> findByPremiereDateAfter(LocalDate reference);


    @Query("SELECT m FROM Movie m WHERE m.title = :param1")
    List<Movie> findAllMoviesByTitle(
            @Param("param1") String title);

    @Query("SELECT m FROM Movie m WHERE m.duration < 2.3 AND m.imdbRating > 7.0")
    List<Movie> findAllShortMoviesWithGoodImdbRating();
}

