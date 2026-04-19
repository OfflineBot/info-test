package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private double duration;

    private LocalDate premiereDate;

    private String description;

    private String trailerUrl;

    private String coverImgUrl;

    private double imdbRating;

    public Movie(String title, double duration, LocalDate premiereDate,
                 String description, String trailerUrl, String coverImgUrl, double imdbRating ) {

        this.title = title;
        this.duration = duration;
        this.premiereDate = premiereDate;
        this.description = description;
        this.trailerUrl = trailerUrl;
        this.coverImgUrl = coverImgUrl;
        this.imdbRating = imdbRating;


    }
}
