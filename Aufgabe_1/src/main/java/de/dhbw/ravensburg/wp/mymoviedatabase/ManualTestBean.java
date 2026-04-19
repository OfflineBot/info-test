package de.dhbw.ravensburg.wp.mymoviedatabase;

import de.dhbw.ravensburg.wp.mymoviedatabase.controller.MovieControllerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ManualTestBean {
    // Vorsicht diese Klasse ist nur für Übungszwecke,
    // sie sollte nie in einer produktiven Applikation sein

    MovieControllerImpl movieController;

    ManualTestBean(MovieControllerImpl movieController){
        this.movieController = movieController;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void callController(){
        log.info(this.movieController.getName());
    }



}
