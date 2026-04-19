package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Soundtrack {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String author_surname;
    private String author_forename;
    private LocalDate releaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;


    public Soundtrack(String title, String author_surname, String author_forename, LocalDate releaseDate){
        this.title = title;
        this.author_surname = author_surname;
        this.author_forename = author_forename;
        this.releaseDate = releaseDate;
    }

}
