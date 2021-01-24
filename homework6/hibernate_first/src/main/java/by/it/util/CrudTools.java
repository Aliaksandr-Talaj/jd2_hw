package by.it.util;

import by.it.pojos.Person;
import org.hibernate.Session;

import java.io.Serializable;

public class CrudTools {

    public static Serializable addPerson(int age, String name, String surname) {
        Serializable temp;
        Session session = HibernateUtil.getSession();
        temp = addPerson(session, age, name, surname);
        session.close();
        return temp;
    }

    public static Serializable addPerson(Session session, int age, String name, String surname) {
        Serializable temp;
        Person person = new Person(null, age, name, surname);
        session.beginTransaction();
        temp = session.save(person);
        session.getTransaction().commit();
        return temp;
    }

    public static Serializable addPerson(Person person) {
        Serializable temp;
        Session session = HibernateUtil.getSession();
        temp = addPerson(session, person);
        session.close();
        return temp;
    }

    public static Serializable addPerson(Session session, Person person) {
        Serializable temp;

        session.beginTransaction();
        temp = session.save(person);
        session.getTransaction().commit();

        return temp;
    }

    public static void updatePerson(int age, String name, String surname) {

        Session session = HibernateUtil.getSession();
        updatePerson(session, age, name, surname);
        session.close();
    }

    public static void updatePerson(Session session, int age, String name, String surname) {

        Person person = new Person(null, age, name, surname);
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();

    }

    public static void updatePerson(Person person) {

        Session session = HibernateUtil.getSession();
        updatePerson(session, person);
        session.close();

    }

    public static void updatePerson(Session session, Person person) {

        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
    }

    public static void deletePerson(int id) {

        try (Session session = HibernateUtil.getSession()) {

            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            session.getTransaction().commit();
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("It seems, that ID " + id + " can not be found");
        }

    }

    public static void deletePerson(Session session, int id) {

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            session.getTransaction().commit();
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("It seems, that ID " + id + " can not be found");
        }

    }

    public static Person findPerson(int id) {
        Person person;
        try (Session session = HibernateUtil.getSession()) {
            person = session.get(Person.class, id);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("It seems, that ID " + id + " can not be found");
            return null;
        }
        return person;
    }

    public static Person findPerson(Session session, int id) {
        Person person;
        try {
            person = session.get(Person.class, id);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("It seems, that ID " + id + " can not be found");
            return null;
        }
        return person;
    }

    public static void flush(Session session) {

        if (session.isDirty()) {
            session.beginTransaction();
            session.flush();
            session.getTransaction().commit();
        }
    }
}
