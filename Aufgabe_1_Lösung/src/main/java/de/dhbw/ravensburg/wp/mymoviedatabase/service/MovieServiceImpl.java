package de.dhbw.ravensburg.wp.mymoviedatabase.service;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public String getName(){
        return "MovieServiceImpl";
    }

}
