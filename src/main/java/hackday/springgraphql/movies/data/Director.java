package hackday.springgraphql.movies.data;

public record Director(int id, String firstName, String lastName ) {

  public String getDirectorName() {
    return firstName + " " + lastName;
  }

  public int getDirectorId(){
    return id;
  }
}
