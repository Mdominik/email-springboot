package pl.com.mazniak.sendingmail.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import pl.com.mazniak.sendingmail.mail.MailService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class MovieController {
    MovieService movieService;
    MailService mailService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        this.mailService = mailService;
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return  ResponseEntity.ok(movieService.getMoviesList());
    }
    @GetMapping(value="/random-movie")
    public ResponseEntity<Movie> getRandomMovie() {
        return  ResponseEntity.ok(movieService.getRandomMovie());
    }

    @PostMapping(value="/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        System.out.println("Adding movie");
        return this.movieService.addMovie(movie.getTitle(), movie.getProductionYear(), movie.getProducer()) ?
            new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
