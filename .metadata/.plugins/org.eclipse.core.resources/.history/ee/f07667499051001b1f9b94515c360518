package helloWorld;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import helloWorld.Artist;

public interface ArtistRep extends CrudRepository<Artist, Integer>{
	
	Iterable<Artist> findByName(String Name);

	
}
