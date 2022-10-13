package com.example.favteacher.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  private int id;
  private String name;
  private String favTeach;

  public Person() {}

  public Person(int id, String name, String favTeach) {
    this.id = id;
    this.name = name;
    this.favTeach = favTeach;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFavTeach() {
    return favTeach;
  }

  public void setFavTeach(String favTeach) {
    this.favTeach = favTeach;
  }
}
