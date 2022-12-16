package rodion.dolgov.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import rodion.dolgov.spring.models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class PersonDAO {
    private  static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Rodik", 23, "dolgovrodion@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sasha",52, "asdf@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Klin", 45, "qwerty@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Ivan", 25, "test@gmail.com"));
    }

    public List<Person> getPeople(){
        return people;
    }

    public Person getMan(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update( int id, Person updatedPerson) {
        getMan(id).setName(updatedPerson.getName());
        getMan(id).setAge(updatedPerson.getAge());
        getMan(id).setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

