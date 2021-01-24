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
        temp = CrudTools.addPerson(33, "Logen","Ninefingers");

        assertNotNull(temp);
    }

    @Test
    public void addPerson1() {
        Serializable temp;
        Person person = new Person(null,33, "Logen","Ninefingers");
        temp = CrudTools.addPerson(person);

        assertNotNull(temp);
    }

    @Test
    public void findPerson() {
        CrudTools.addPerson(33, "Logen","Ninefingers");
        CrudTools.addPerson(33, "Logen","Ninefingers");
        CrudTools.addPerson(33, "Logen","Ninefingers");
        assertNotNull(CrudTools.findPerson(1));
    }

    @Test
    public void deletePerson() {
        CrudTools.addPerson(33, "Logen","Ninefingers");
        CrudTools.addPerson(33, "Logen","Ninefingers");
        CrudTools.addPerson(33, "Logen","Ninefingers");
        CrudTools.deletePerson(3);

        assertNull(CrudTools.findPerson(3));

    }

    @Test
    public void testUpdatePerson() {
        Session session = HibernateUtil.getSession();
        Person person = new Person(5,33, "Logen","Ninefingers");

        CrudTools.addPerson(session,person);
        person.setSurname("Bloody-Nine");
        CrudTools.updatePerson(session, person);
        Person person1 = CrudTools.findPerson(5);
        assertEquals(person1.getSurname(),person.getSurname());

    }

    @Test
    public void flush() {
        Session session = HibernateUtil.getSession();
        CrudTools.flush(session);
        assertFalse(session.isDirty());
    }
}