package rodion.dolgov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rodion.dolgov.spring.dao.PersonDAO;
import rodion.dolgov.spring.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getPeople(Model model){
        model.addAttribute("people", personDAO.getPeople());
        return "people/allPeople";
    }

    @GetMapping("/{id}")
    public String getMan(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.getMan(id));
        return "people/man";
    }

    @GetMapping("/newPerson")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());

        return "/people/newPerson";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.getMan(id));
        return "people/edit"; // путь к представлению
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
