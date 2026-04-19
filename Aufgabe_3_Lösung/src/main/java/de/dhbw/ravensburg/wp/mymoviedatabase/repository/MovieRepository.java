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

    @Query("SELECT m FROM Movie m WHERE m.title like %:param1%")
    List<Movie> findAllMoviesBelongingToSeries(@Param("param1") String series);

    @Query("SELECT m FROM Movie m JOIN m.involvedMovieCast c " +
            "WHERE c.surname = :param1")
    List<Movie> findAllMoviesWithCastSurname(@Param("param1") String castSurname);

    @Query("SELECT m FROM Movie m " +
            "WHERE m.soundtrack.author_surname = :param1")
    List<Movie> findAllMoviesWithSoundtrackAuthor(@Param("param1") String castSurname);

    @Query("SELECT m FROM Movie m " +
            "WHERE size(m.involvedMovieCast) > :param1")
    List<Movie> findAllMoviesWithMoreThanGivenCasts(@Param("param1") Integer num);

    @Query("SELECT m FROM Movie m JOIN m.awards a WHERE a.academy = :param1")
    List<Movie> findAllMoviesByAcademy(@Param("param1") String academy);

    // Aufgabe 3e)
    @Query("SELECT m FROM Movie m JOIN m.awards a WHERE " +
            "a.category = :param1 AND " +
            "size(m.involvedMovieCast) > 0 AND " +
            "m.soundtrack.releaseDate > :param2 AND " +
            "m.soundtrack.releaseDate < :param3")
    List<Movie> findMoviesByCastSizeAndSoundtrack(@Param("param1") String category,
                                                  @Param("param2") LocalDate minDate,
                                                  @Param("param3") LocalDate maxDate);

    // Aufgabe 3f)
    @Query("SELECT m FROM Movie m JOIN m.involvedMovieCast c JOIN m.awards a WHERE " +
            "c.surname = :param1 AND " +
            "a.academy = :param2")
    List<Movie> myMoviesByCastAndAward(@Param("param1") String surname, @Param("param2") String academy);

    // Aufgabe 3g)
    @Query("SELECT m FROM Movie m JOIN m.awards a WHERE " +
            "a.academy = :param1 AND " +
            "a.yearAwarded = :param2 AND " +
            "m.soundtrack.author_forename = :param3 AND " +
            "m.soundtrack.author_surname = :param4" )
    List<Movie> awardedMoviesWithZimmerSoundtrack(
            @Param("param1") String academy,
            @Param("param2") int yearAwarded,
            @Param("param3") String forename,
            @Param("param4") String surname
    );


}
