package helloWorld;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class HelloController {
	

	@Autowired
	private ArtistRep artistRep;
	
	@RequestMapping(path="/add")
	public @ResponseBody String addNewArtist (@RequestParam String name
		      , @RequestParam Integer id) {
		Artist newArtist = new Artist();
		newArtist.setName(name);
		newArtist.setId(id);
		artistRep.save(newArtist);
		return "Saved";
	}
	
	
	
	  @RequestMapping(path="/all")
	  public @ResponseBody String getAllArtist(@RequestParam String name) {
	    Iterable<Artist> iterable = artistRep.findByName(name);
	    String items = "<ul>";
	    for(Artist artist:iterable) {
	    	System.out.println(artist.getName() + "*****");
	    		items = items + "<li>" + artist.getName() + "</li>";
	    }
	    items = items + "</ul>";
		return items;
	  }
	  
	  

}
