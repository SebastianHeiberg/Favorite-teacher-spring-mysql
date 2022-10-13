package com.example.favteacher.service;

import com.example.favteacher.model.Person;
import com.example.favteacher.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  @Autowired
  PersonRepo personRepo;

  public List<Person> fetchPersons () {
    return personRepo.fetchAllPersons();
  }

  public void addPerson (Person person) {
  personRepo.addPerson(person);
  }

  public Person findPersonById(int id) {
    return personRepo.findPersonById(id);
  }

  public void updatePerson (Person person) {
    personRepo.updatePerson(person);
  }

  public void deletePerson(int id) {
    personRepo.deletePerson(id);
  }
}
