package hackday.springgraphql.movies.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import hackday.springgraphql.movies.data.Director;

@Repository
public class DirectorRepository {

  private List<Director> directorList = new ArrayList<>();

  public List<Director> findAll(){
    return directorList;
  };

  public Director findByName(String name){
    return directorList.stream()
            .filter(director -> director.getDirectorName().equals(name))
            .findAny()
            .orElse(null);
  }

  @PostConstruct
  private void init(){
    directorList.add(new Director(1, "Dennis", "Berg"));
    directorList.add(new Director(2, "Kalle", "Anka"));
    directorList.add(new Director(3, "Steven", "Spielberg"));
  }

}
