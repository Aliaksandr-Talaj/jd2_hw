package by.it.pojos;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@Entity
@Table
public class Person implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private Integer age;
    @Column (length = 100)
    private String name;
    @Column (length = 500)
    private String surname;

    @Embedded
    private Address address;

    public Person(){
        super();
    }

    public Person(Integer id, Integer age, String name, String surname) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public Person(Integer id, Integer age, String name, String surname, Address address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
