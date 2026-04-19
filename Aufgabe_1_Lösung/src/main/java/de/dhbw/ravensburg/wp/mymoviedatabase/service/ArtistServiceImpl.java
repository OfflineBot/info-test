package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Override
    public String getName(){
        return "ArtistServiceImpl";
    }

}
