package com.example.favteacher.repository;

import com.example.favteacher.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepo {

  @Autowired
  JdbcTemplate template;

  public List<Person> fetchAllPersons () {
    String sql = "Select * from person order by favTeach";
    RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
    return template.query(sql,rowMapper);
  }

  public void addPerson (Person p) {
    String sql = "insert into person(id,name,favTeach) values(?,?,?)";
    template.update(sql,p.getId(),p.getName(),p.getFavTeach());
  }

  public void updatePerson(Person person) {
    String sql = "update person set name = ?, favTeach = ? where id = ?";
    template.update(sql,person.getName(),person.getFavTeach(),person.getId());

  }

  public void deletePerson(int id) {
    String sql = "delete from person where id = ?";
    template.update(sql,id);
  }

  public Person findPersonById(int id){
    String sql = "Select * from person where id = ?";
    RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
    return template.queryForObject(sql,rowMapper,id);
  }

}
