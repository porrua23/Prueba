package com.howtodoinjava.rest.model;
 
public class Superhero {
 
    public Superhero() {
 
    }
 
    public Superhero(Integer id, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
  
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
 
    //Getters and setters
 
    @Override
    public String toString() {
        return "Superhero [id=" + id + ", firstName=" + firstName + ", 
                lastName=" + lastName + ", email=" + email + "]";
    }
}