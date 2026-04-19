package de.dhbw.ravensburg.wp.mymoviedatabase;

import de.dhbw.ravensburg.wp.mymoviedatabase.controller.MovieController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ManualTestBean {
    // Vorsicht diese Klasse ist nur für Übungszwecke,
    // sie sollte nie in einer produktiven Applikation sein

    MovieController movieController;

    ManualTestBean(MovieController movieController){
        this.movieController = movieController;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){

        log.info("Controller: "+this.movieController.getName());
        log.info("MovieService: "+this.movieController.getMovieServiceName());
        log.info("ArtistService: "+this.movieController.getArtistServiceName());
    }

}
