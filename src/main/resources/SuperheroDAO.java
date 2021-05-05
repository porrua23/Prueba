package com.howtodoinjava.rest.dao;
 
import org.springframework.stereotype.Repository;
 
import com.howtodoinjava.rest.model.Superhero;
import com.howtodoinjava.rest.model.Superheroes;
 
@Repository
public class SuperheroDAO 
{
    private static Superheros list = new Superheroes();
     
    static
    {
        list.getSuperheroList().add(new Superhero(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getSuperheroList().add(new Superhero(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getSuperheroList().add(new Superhero(3, "David", "Kameron", "titanic@gmail.com"));
    }
     
    public Superheros getAllSuperheros() 
    {
        return list;
    }
     
    public void addSuperhero(Superhero employee) {
        list.getSuperheroList().add(employee);
    }
}
