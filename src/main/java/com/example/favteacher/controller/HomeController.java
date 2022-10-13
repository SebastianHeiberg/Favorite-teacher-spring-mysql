package com.example.favteacher.controller;

import com.example.favteacher.model.Person;
import com.example.favteacher.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @Autowired
  PersonService personService;

  @GetMapping("/")
  public String showHome(Model model) {
    model.addAttribute("persons", personService.fetchPersons());
    return "index";
  }

  @GetMapping("create")
  public String showCreate() {
    return "create";
  }

  @PostMapping("create")
  public String makeStudent(@ModelAttribute Person person) {
  personService.addPerson(person);
    return "redirect:/";
  }

  @GetMapping("update/{id}")
  public String showUpdate(@PathVariable ("id") int id, Model model) {
    model.addAttribute("person",personService.findPersonById(id));
    return "update";
  }

  @PostMapping("update")
  public String updateStudent(@ModelAttribute Person person) {
    personService.updatePerson(person);
    return "redirect:/";
  }

  @GetMapping("delete/{id}")
  public String delete(@PathVariable("id") int id){
    personService.deletePerson(id);
    return "redirect:/";
  }

}
