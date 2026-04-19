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
public class Director {

    @Id
    @GeneratedValue
    private long id;

    private String forename;

    private String surname;

    private LocalDate dateOfBirth;

    private String profileImgUrl;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Movie> movies;

    public Director(String surname, String forename, LocalDate dateOfBirth,
                    String profileImgUrl){
        this.surname = surname;
        this.forename = forename;
        this.dateOfBirth = dateOfBirth;
        this.profileImgUrl = profileImgUrl;
    }



}
