package rodion.dolgov.spring.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import rodion.dolgov.spring.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> getPeople() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Person p", Person.class).getResultList();
    }

    public Optional<Person> getManByEmail(String email) {
        return null;
    }

    @Transactional
    public Person getManById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Person p where p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void save(Person person) {

    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {

    }
}
