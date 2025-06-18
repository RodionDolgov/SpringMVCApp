package rodion.dolgov.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rodion.dolgov.spring.models.Person;
import rodion.dolgov.spring.services.PeopleService;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;


    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (peopleService.findByEmail(person.getEmail()).isPresent()
                && person.getId() != peopleService.findByEmail(person.getEmail()).get().getId()) {
            errors.rejectValue("email", "", "This email is already taken");
        }

        if (!Character.isUpperCase(person.getName().charAt(0))) {
            errors.rejectValue("name", "", "The name should start with a capital letter");
        }
    }
}
