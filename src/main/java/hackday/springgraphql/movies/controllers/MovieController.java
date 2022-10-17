package hackday.springgraphql.movies.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import hackday.springgraphql.movies.data.Movie;
import hackday.springgraphql.movies.repository.MovieRepository;

@Controller
public class MovieController {

  private final MovieRepository movieRepository;

  public MovieController(MovieRepository movieRepository){
    this.movieRepository = movieRepository;
  }

  @SchemaMapping(typeName = "Query", value = "getAllMovies")
  public List<Movie> getAll() {
    return movieRepository.findAll();
  }

  // @SchemaMapping(typeName = "Query", value = "findOne")
  @QueryMapping
  public Movie findOne(@Argument int id){
    return movieRepository.findOne(id);
  }

}
