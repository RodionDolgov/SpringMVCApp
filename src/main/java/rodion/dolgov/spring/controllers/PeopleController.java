package rodion.dolgov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rodion.dolgov.spring.dao.PersonDAO;

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
}
