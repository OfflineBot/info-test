package de.dhbw.ravensburg.wp.mymoviedatabase.controller;

import de.dhbw.ravensburg.wp.mymoviedatabase.service.ArtistService;
import de.dhbw.ravensburg.wp.mymoviedatabase.service.MovieService;
import org.springframework.stereotype.Controller;

@Controller
public class MovieControllerImpl implements MovieController {

    private MovieService movieService;
    private ArtistService artistService;

    public MovieControllerImpl(MovieService movieService, ArtistService artistService){
        this.movieService = movieService;
        this.artistService = artistService;
    }


    @Override
    public String getName(){
        return "MovieControllerImpl";
    }

    @Override
    public String getMovieServiceName(){
        return this.movieService.getName();
    }

    @Override
    public String getArtistServiceName(){
        return this.artistService.getName();
    }
}
