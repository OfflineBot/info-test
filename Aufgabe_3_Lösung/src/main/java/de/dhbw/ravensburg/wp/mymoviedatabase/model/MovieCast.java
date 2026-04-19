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
public class MovieCast {
    @Id
    @GeneratedValue
    private long id;

    private String forename;

    private String surname;

    private LocalDate dateOfBirth;

    private String profileImgUrl;

    private double height;

    @ManyToMany(mappedBy = "involvedMovieCast", cascade = CascadeType.PERSIST)
    private List<Movie> participatedMovies;

    public MovieCast(String surname, String forename, LocalDate dateOfBirth, String profileImgUrl, double height){
        this.surname = surname;
        this.forename = forename;
        this.dateOfBirth = dateOfBirth;
        this.profileImgUrl = profileImgUrl;
        this.height = height;
    }




}
