package hackday.springgraphql.movies.data;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {

  ONE_STAR("⭐️"),
  TWO_STAR("⭐️⭐️"),
  THREE_STAR("⭐️⭐️⭐️"),
  FOUR_STAR("⭐️⭐️⭐️⭐️"),
  FIVE_STAR("⭐️⭐️⭐️⭐️⭐️");

  private String star;

  Rating(String star){
    this.star = star;
  }

  @JsonValue
  public String getStar() {
    return star;
  }

}
