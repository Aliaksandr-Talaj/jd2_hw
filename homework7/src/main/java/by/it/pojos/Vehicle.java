package by.it.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Vehicle {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column
    @Access(AccessType.PROPERTY)
    private String id;

    @Column
    @Access(AccessType.PROPERTY)
    private VehicleType vehicleType;

    @Column
    @Access(AccessType.FIELD)
    private String brand;

    @Column
    @Access(AccessType.FIELD)
    private String model;

    @Column
    @Access(AccessType.FIELD)
    private String color;

    @Column
    @Access(AccessType.PROPERTY)
    private String registrationNumber;

    @Column
    @Access(AccessType.PROPERTY)
    private String vinNumber;


}