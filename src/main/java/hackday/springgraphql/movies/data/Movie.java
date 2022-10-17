package hackday.springgraphql.movies.data;

public record Movie(int id, String title, Director director, Rating rating  ) {

  public String getMovieTitle(){
    return title;
  };

}
