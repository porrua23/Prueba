package com.howtodoinjava.rest.model;
 
import java.util.ArrayList;
import java.util.List;
 
public class Superheroes
{
    private List<Superhero> superheroList;
     
    public List<Superhero> getSuperheroList() {
        if(superheroList == null) {
            superheroList = new ArrayList<>();
        }
        return superheroList;
    }
  
    public void setSuperheroList(List<Superhero> superheroList) {
        this.superheroList = superheroList;
    }
}