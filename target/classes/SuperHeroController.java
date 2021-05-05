package com.howtodoinjava.rest.controller;
 
import java.net.URI;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 
import com.howtodoinjava.rest.dao.superheroDAO;
import com.howtodoinjava.rest.model.superhero;
import com.howtodoinjava.rest.model.superheros;
 
@RestController
@RequestMapping(path = "/superheroes")
public class SuperHeroController 
{
	  @Autowired
	    private SuperheroRepository superheroRepository;

	    @GetMapping("/superheroes")
	    public List<Superhero> getAllSuperheroes() {
	        return superheroRepository.findAll();
	    }

	    @GetMapping("/superheroes/{id}")
	    public ResponseEntity<Superhero> getSuperheroById(@PathVariable(value = "id") Long superheroId)
	      throws ResourceNotFoundException {
	        Superhero superhero = superheroRepository.findById(superheroId)
	           .orElseThrow(() -> new ResourceNotFoundException("Superhero not found for this id :: " + superheroId));
	        return ResponseEntity.ok().body(superhero);
	    }

	    @PutMapping("/superheroes/{id}")
	    public ResponseEntity<Superhero> updateSuperhero(@PathVariable(value = "id") Long superheroId,
	      @Valid @RequestBody Superhero superheroDetails) throws ResourceNotFoundException {
	        Superhero superhero = superheroRepository.findById(superheroId)
	           .orElseThrow(() -> new ResourceNotFoundException("Superhero not found for this id :: " + superheroId));
	        final Superhero updatedSuperhero = superheroRepository.save(superhero);
	        return ResponseEntity.ok(updatedSuperhero);
	    }

	    @DeleteMapping("/superheroes/{id}")
	    public Map<String, Boolean> deleteSuperhero(@PathVariable(value = "id") Long superheroId)
	      throws ResourceNotFoundException {
	        Superhero superhero = superheroRepository.findById(superheroId)
	          .orElseThrow(() -> new ResourceNotFoundException("Superhero not found for this id :: " + superheroId));

	        superheroRepository.delete(superhero);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}