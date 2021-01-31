package by.it.util;

import by.it.pojos.Person;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class CrudToolsTest {

    @Test
    public void addPerson() {
        Serializable temp;
        temp = CrudTools.addPerson(33, "Logen", "Ninefingers");

        assertNotNull(temp);
    }

    @Test
    public void addPerson1() {
        Serializable temp;
        Person person = new Person(null, 33, "Logen", "Ninefingers");

        temp = CrudTools.addPerson(person);

        assertNotNull(temp);
    }

    @Test
    public void findPerson() {
        Person person = new Person(null, 33, "Logen", "Ninefingers");
        CrudTools.addPerson(person);
        int id = person.getId();
        CrudTools.addPerson(33, "Logen1", "Ninefingers1");
        CrudTools.addPerson(33, "Logen2", "Ninefingers2");
        assertNotNull(CrudTools.findPerson(id));
    }

    @Test
    public void deletePerson() {
        CrudTools.addPerson(33, "Logen", "Ninefingers");
        CrudTools.addPerson(33, "Logen", "Ninefingers");
        CrudTools.addPerson(33, "Logen", "Ninefingers");
        CrudTools.deletePerson(3);

        assertNull(CrudTools.findPerson(3));

    }

    @Test
    public void testRefresh() {
        Session session = HibernateUtil.getSession();
        Person person = new Person(5, 33, "Logen", "Ninefingers");

        CrudTools.addPerson(session, person);
        person.setSurname("Bloody-Nine");

        session.refresh(person);
        Person person1 = CrudTools.findPerson(5);
        assertEquals(person1.getSurname(), person.getSurname());

    }


    @Test
    public void testUpdatePerson() {

        Person person = new Person(5, 33, "Logen", "Ninefingers");

        CrudTools.addPerson(person);
        person.setSurname("Bloody-Nine");
        CrudTools.updatePerson(person);
        Person person1 = CrudTools.findPerson(5);
        assertNotEquals(person.getSurname(), person1.getSurname());

    }

    @Test
    public void flush() {
        Session session = HibernateUtil.getSession();
        CrudTools.flush(session);
        assertFalse(session.isDirty());
    }
}