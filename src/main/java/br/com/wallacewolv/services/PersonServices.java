package br.com.wallacewolv.services;

import br.com.wallacewolv.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName " + i );
        person.setLastName("LastName" + i);
        person.setAddress("Some Address in Brasil");
        person.setGender("Male");

        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Wallace");
        person.setLastName("Oliveira");
        person.setAddress("São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }
}
