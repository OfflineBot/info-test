package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Award {

    @Id
    @GeneratedValue
    private Long id;

    private String academy;
    private String category;
    private int yearAwarded;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;


    public Award(String academy, String category, int yearAwarded){
        this.academy = academy;
        this.category = category;
        this.yearAwarded = yearAwarded;
    }

}
