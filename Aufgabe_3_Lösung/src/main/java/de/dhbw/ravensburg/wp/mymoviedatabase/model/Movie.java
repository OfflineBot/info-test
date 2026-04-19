package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="director_id", nullable = true)
    private Director director;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_moviecast",
            joinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "cast_id", referencedColumnName = "id")})
    private List<MovieCast> involvedMovieCast;


    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Soundtrack soundtrack;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Award> awards;


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
