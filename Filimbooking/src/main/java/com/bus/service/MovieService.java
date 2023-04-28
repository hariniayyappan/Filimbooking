package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.beans.MovieDetails;





@Service
public class MovieService {
	
	@Autowired
    private MovieRepo movierepo;

	public List<MovieDetails> listAll() {
		
		{
			System.out.println(movierepo.findAll());
	        return movierepo.findAll();
	    }
	}
	public void saveMovie(MovieDetails movieDetails) {
		movierepo.save(movieDetails);
    }
	
		
	public MovieDetails get(long movieId) {
        return movierepo.findById(movieId).get();
    }
	
	public void deleteMovie(long movieId) {
        movierepo.deleteById(movieId);
    }
	public void deleteMovieDetailsBymovieId(long movieId) {
		movierepo.deleteById(movieId);
		
	}
		public static Object getAllMovieDetails1() {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<MovieDetails> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	

	


}	
	
