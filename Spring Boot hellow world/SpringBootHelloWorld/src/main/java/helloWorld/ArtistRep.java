package helloWorld;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import helloWorld.Artist;

@Repository
public interface ArtistRep extends CrudRepository<Artist, Integer> {

	@Query(value = "SELECT * FROM Artist a WHERE a.name like '%?1%'", nativeQuery = true)
	Iterable<Artist> findByName(String Name);

}
