package pl.com.mazniak.sendingmail.movie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class MovieService {

    List<Movie> moviesList;

    public MovieService() {
        this.moviesList = new LinkedList<>();
        moviesList.add(new Movie("Jurassic Park", 1996, "Spielberg"));
        moviesList.add(new Movie("Interstellar", 2014, "Chris Nolan"));
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public Movie getRandomMovie() {
        Random random = new Random();
        return this.moviesList.get(Math.abs(random.nextInt()) % this.moviesList.size());
    }

    public boolean addMovie(Movie movie) {
        return this.moviesList.add(movie);
    }

    public boolean addMovie(String title, int productionYear, String producer) {
        return this.moviesList.add(new Movie(title,productionYear,producer));
    }
}
