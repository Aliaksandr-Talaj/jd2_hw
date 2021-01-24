package by.it.loader;


import by.it.pojos.Person;
import by.it.util.CrudTools;
import by.it.util.HibernateUtil;
import org.hibernate.Session;


public class PersonLoader {

    public static void main(String[] args) throws Exception {

        Session session = HibernateUtil.getSession();

        //Adding users
        CrudTools.addPerson(session, 35, "Yuli", "Slabko");
        CrudTools.addPerson(session, 33, "Logen", "Ninefingers");

        //Changing second row
        Person person;
        person = CrudTools.findPerson(session, 2);
        try{ person.setSurname("Bloody-Nine");

            CrudTools.updatePerson(person);
        }catch (NullPointerException e){
            System.out.println("Loading error");
        }
        //Adding third row
        CrudTools.addPerson(session, 33, "Logen", "Ninefingers");
        //Trying to change third row with intermediate refresh
        person = CrudTools.findPerson(session, 3);
        try {
            person.setSurname("Bloody-Nine");
            System.out.println("Surname before refreshing: "+person.getSurname());
            session.refresh(person);
            System.out.println("Surname after refreshing: "+person.getSurname());
            CrudTools.updatePerson(person);
        }catch (NullPointerException e){
            System.out.println("Loading error");
        }
        CrudTools.flush(session);

        //Adding additional row, deleting the first row
        CrudTools.addPerson(session, 40, "Doe", "Black");
       CrudTools.deletePerson(session, 1);

       session.close();

    }

}
