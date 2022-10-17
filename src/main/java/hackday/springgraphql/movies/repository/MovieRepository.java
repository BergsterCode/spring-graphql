package hackday.springgraphql.movies.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import hackday.springgraphql.movies.data.Movie;
import hackday.springgraphql.movies.data.Rating;

@Repository
public class MovieRepository {

  private final DirectorRepository directorRepository;

  private List<Movie> movieList = new ArrayList<>();

      public MovieRepository(DirectorRepository directorRepository) {
      this.directorRepository = directorRepository;
  }

  public List<Movie> findAll() {
      return movieList;
  }

  public Movie findOne(Integer id) {
      return movieList.stream()
              .filter(movie -> movie.id() == id)
              .findFirst().orElseThrow(() -> new RuntimeException("Could not find movie: "));
  }

  @PostConstruct
  private void init() {
    movieList.add(new Movie(1, "GraphQL is cool", directorRepository.findByName("Dennis Berg"), Rating.FOUR_STAR));
    movieList.add(new Movie(2, "Lord of the GraphQl", directorRepository.findByName("Dennis Berg"), Rating.ONE_STAR));
    movieList.add(new Movie(3, "GraphQL Wars", directorRepository.findByName("Steven Spielberg"), Rating.FOUR_STAR));
    movieList.add(new Movie(4, "Some disney movie", directorRepository.findByName("Kalle Anka"), Rating.FOUR_STAR));
  }
}
