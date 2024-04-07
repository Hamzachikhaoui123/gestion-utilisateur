package com.hamza.demo.adress;

import com.hamza.demo.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    private String id;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    @OneToOne
    @JoinColumn(name = "employee-id")
    private Employee employee;
}
